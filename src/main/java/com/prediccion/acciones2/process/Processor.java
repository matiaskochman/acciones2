package com.prediccion.acciones2.process;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.prediccion.acciones2.domain.Company;
import com.prediccion.acciones2.domain.QueryLog;
import com.prediccion.acciones2.exception.BusinessException;
import com.prediccion.acciones2.utils.HttpConectionUtils;
import com.prediccion.acciones2.utils.ParsingUtils;

public class Processor implements Runnable{
	QueryLog queryLog;
	Calendar cal;
	CountDownLatch countDownLatch;
	Company company;
	String data;
	//Pattern precio_accion_pattern = Pattern.compile("results\\\":\\{\\\"span\\\":\\[\\\"\\d+(.)\\d+");
	//Pattern precio_accion_pattern = Pattern.compile("lastPrice.{37}\\\"content\\\":\\\"\\d+(?:.\\d+)\\\"");
	
	
	
	Pattern recomendacion_buy = Pattern.compile("Buy"+ParsingUtils.common);
	Pattern recomendacion_outperform = Pattern.compile("Outperform"+ParsingUtils.common);
	Pattern recomendacion_hold = Pattern.compile("Hold"+ParsingUtils.common);
	Pattern recomendacion_underperform = Pattern.compile("Underperform"+ParsingUtils.common);
	Pattern recomendacion_sell = Pattern.compile("Underperform"+ParsingUtils.common);
	Pattern recomendacion_no_opinion = Pattern.compile("No opinion"+ParsingUtils.common);
			
	TreeSet<Company> treeSet;

	public Processor(CountDownLatch countDownLatch,Company company,TreeSet<Company> set,Calendar cal, QueryLog queryLog) {
		super();
		this.company=company;
		this.countDownLatch = countDownLatch;
		this.treeSet = set;
		this.cal = cal;
		this.queryLog = queryLog;
	}

	private String extract_volumen_negociado(Pattern p){
		Matcher m = p.matcher(data);
		if(m.find()){
			int start=m.start();
			int end=m.end();
			String precio = data.substring(start, end);
			Pattern valor = Pattern.compile("\\d+(?:.\\d*)[km]");
			Matcher get_value_pattern = valor.matcher(precio);
			if(get_value_pattern.find()){
				String valor1 = precio.substring(get_value_pattern.start(), get_value_pattern.end());
				 //this.company.setRecomendacionOutPerform(new Integer(valor1)) ;
				return new String(valor1);
			}else{
				System.out.println("encontro el match de la recomendacion pero no el valor");
			}
			
		}
		return "0";
	}
	
	private Integer extract_recomendacion(Pattern p){
		Matcher m = p.matcher(data);
		if(m.find()){
			int start=m.start();
			int end=m.end();
			String precio = data.substring(start, end);
			Pattern valor = Pattern.compile("\\d");
			Matcher get_value_pattern = valor.matcher(precio);
			if(get_value_pattern.find()){
				String valor1 = precio.substring(get_value_pattern.start(), get_value_pattern.end());
				 //this.company.setRecomendacionOutPerform(new Integer(valor1)) ;
				return new Integer(valor1);
			}else{
				System.out.println("encontro el match de la recomendacion pero no el valor");
			}
		}else{
			System.out.println("no encontro valor de la recomendacion ");
		}
		return 0;
	}
	
	
	
	private Double extract_precio_accion(Pattern p){
		Matcher m = p.matcher(data);
		
		if(m.find()){
			int start=m.start();
			int end=m.end();
			String precio = data.substring(start, end);
			Pattern valor = Pattern.compile("-*\\d+\\.*\\d*");
			Matcher m_precio_accion = valor.matcher(precio);
			if(m_precio_accion.find()){
				String valor_precio_accion = precio.substring(m_precio_accion.start(), m_precio_accion.end());
				//this.company.setStockValue(new Double(valor_precio_accion)) ;
				valor_precio_accion=valor_precio_accion.replaceAll(",", ".");
				return new Double(valor_precio_accion);
			}
		}else {
			System.out.println("yql extract -- la accion no tiene precio");
		}
		
		return -1D;
	}
	
	private void extract_forecast_valoresAbsolutos(Pattern forecast_valores_absolutos) {
		
		Matcher m = forecast_valores_absolutos.matcher(data);
		 int start1 = 0;
		 int start2 = 0;
		 int start3 = 0;
		 int end1 = 0;
		 int end2 = 0;
		 int end3 = 0;
		 
		 
		 List<Double> listVal = new ArrayList<Double>();
		 
		 if(m.find()){
			 start1 = m.start();
			 end1 = m.end();

			 String val1 = data.substring(start1, end1);
			 val1.length();
			 Pattern number_pattern = Pattern.compile("\\d+.\\d\\d");
			 Matcher number_matcher = number_pattern.matcher(val1);
			 String value;
			 for (int i = 1; i <= 3; i++) {
				if(number_matcher.find()){
					value = val1.substring(number_matcher.start(), number_matcher.end());
					value = value.replaceAll(",",".");
					listVal.add(Double.valueOf(value));
					
				}
				
			}
			 
			company.setMaxForecastValue(listVal.get(0));
			company.setMedForecastValue(listVal.get(1));
			company.setMinForecastValue(listVal.get(2));
			
		 }
		
	}
	
	private void extract_recommendationsPopup_lastYear() throws Exception {
		Matcher m = ParsingUtils.recomendations_popup_last_year.matcher(data);
		 int start1 = 0;
		 int end1 = 0;

		 if(m.find()){
			 start1 = m.start();
			 end1 = m.end();
			 String val1 = data.substring(start1, end1);
			 
			 if(val1!=null && !val1.equals("")){
				 Matcher m_buy = ParsingUtils.recomentations_last_year_buy.matcher(val1);		 
				 Matcher m_hold = ParsingUtils.recomentations_last_year_hold.matcher(val1);		 
				 Matcher m_outperform = ParsingUtils.recomentations_last_year_outperform.matcher(val1);		 
				 Matcher m_sell = ParsingUtils.recomentations_last_year_sell.matcher(val1);		 
				 Matcher m_underperform = ParsingUtils.recomentations_last_year_underperform.matcher(val1);		 
				 
				 if(m_buy.find()){
					 String buy_string = val1.substring(m_buy.start(), m_buy.end());
					 
					 Matcher number_matcher = ParsingUtils.number.matcher(buy_string);
					 
					 if(number_matcher.find()){
						 company.setRecomendacionBuy_last_year(Integer.valueOf(buy_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 if(m_hold.find()){
					 String hold_string = val1.substring(m_hold.start(), m_hold.end());
					 
					 Matcher number_matcher = ParsingUtils.number.matcher(hold_string);
					 
					 if(number_matcher.find()){
						 company.setRecomendacionHold_last_year(Integer.valueOf(hold_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 if(m_outperform.find()){
					 String outperform_string = val1.substring(m_outperform.start(), m_outperform.end());
					 Matcher number_matcher = ParsingUtils.number.matcher(outperform_string);
					 if(number_matcher.find()){
						 company.setRecomendacionOutPerform_last_year(Integer.valueOf(outperform_string.substring(number_matcher.start(), number_matcher.end())));
					 }
					 
				 }
				 if(m_sell.find()){
					 String sell_string = val1.substring(m_sell.start(), m_sell.end());
					 Matcher number_matcher = ParsingUtils.number.matcher(sell_string);
					 if(number_matcher.find()){
						 company.setRecomendacionSell_last_year(Integer.valueOf(sell_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 if(m_underperform.find()){
					 String underperform_string = val1.substring(m_underperform.start(), m_underperform.end());
					 Matcher number_matcher = ParsingUtils.number.matcher(underperform_string);
					 if(number_matcher.find()){
						 company.setRecomendacionUnderPerform_last_year(Integer.valueOf(underperform_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 
			 }
		 }
		 
		 company.generateOpinionAverage_last_year();
		
	}
	
	private void extract_forecast_porcentaje() throws Exception {
		Matcher m = ParsingUtils.forecast_porcentaje_pattern.matcher(data);
		 int start1 = 0;
		 int start2 = 0;
		 int start3 = 0;
		 int end1 = 0;
		 int end2 = 0;
		 int end3 = 0;
		 
		 if(m.find()){
			 
			 String string = data;
			 
			 start1 = m.start();
			 end1 = m.end();
			 
			 m.find(end1);
			 
			 start2 = m.start();
			 end2 = m.end();
			 
			 m.find(end2);
			
			 start3 = m.start();
			 end3 = m.end();

			 String val3 = data.substring(start3, end3);
			 String val2 = data.substring(start2, end2);
			 String val1 = data.substring(start1, end1);
			 
			 if(val1.substring(val1.length()-2, val1.length()-1).equals(" ")){
				 val1 = data.substring(start1, end1-2);
			 }else{
				 val1 = data.substring(start1, end1-1);
			 }
			 
			 if(val2.substring(val2.length()-2, val2.length()-1).equals(" ")){
				 val2 = data.substring(start2, end2-2);
			 }else{
				 val2 = data.substring(start2, end2-1);
			 }
			 
			 if(val3.substring(val3.length()-2, val3.length()-1).equals(" ")){
				 val3 = data.substring(start3, end3-2);
			 }else{
				 val3 = data.substring(start3, end3-1);
			 }
			 
			 if(val1 == null || val2 ==null || val3 == null){
				 System.out.println("mal parseado: "+data);
			 }
			 
			 this.company.setMaxForecastPercentageValue(new Double(val1.replaceAll(",", "."))) ;
			 this.company.setMedForecastPercentageValue(new Double(val2.replaceAll(",", ".")));
			 this.company.setMinForecastPercentageValue(new Double(val3.replaceAll(",", ".")));

			 
			 treeSet.add(company);

			 /*
			 if(company.getMaxForecastPercentageValue()!=null||company.getMinForecastPercentageValue()!=null||company.getMedForecastPercentageValue()!=null){
				 if(company.getMaxForecastPercentageValue().equals(company.getMinForecastPercentageValue())&&company.getMaxForecastPercentageValue().equals(company.getMedForecastPercentageValue())){
					throw new BusinessException("3 values are equal"); 
				 }
				 
				 if(CompanyFilter.percentageForecastIntegrityValid(company)){
				 }else{
					throw new BusinessException("integrity of max med min percentages values broken."); 
				 }
			 }
			 */
		 }
	}
	
	@Override
	public void run() {
		try {
			
			StringBuffer sb = new StringBuffer();
			
			String baseUrl = "http://query.yahooapis.com/v1/public/yql?q=";
			
			final String financialTimes = "http://markets.ft.com/research/Markets/Tearsheets/Forecasts?s="+this.company.getTicker()+this.company.getMarket();
			
			sb.append("select * from html where url='");
			sb.append(financialTimes);
			sb.append("' ");
			sb.append("and xpath='");
			sb.append(ParsingUtils.porcentajeForecast);
			sb.append("|");
			sb.append(ParsingUtils.latestRecomendations);
			sb.append("|");
			sb.append(ParsingUtils.precioAccion);
			sb.append("|");
			sb.append(ParsingUtils.sharesTraded);
			sb.append("|");
			sb.append(ParsingUtils.valoresForecast);
			sb.append("|");
			sb.append(ParsingUtils.latestRecomentations_buy);
			sb.append("'");
			
			final String fullUrlStr = baseUrl + URLEncoder.encode(sb.toString(), "UTF-8") + "&format=json";
			
			System.out.println(fullUrlStr);
			
			data = HttpConectionUtils.getData(fullUrlStr);
			
			extract_forecast_porcentaje();
			
			extract_recommendationsPopup_lastYear();
			
			if(company.getMinForecastPercentageValue()==null){
				throw new BusinessException("no pudo parsear los valores de forecast para "+company.getTicker()+":"+company.getExchange()+" "+
			"countdownlatch: "+countDownLatch.getCount());
			}
			
			extract_forecast_valoresAbsolutos(ParsingUtils.forecast_valores_pattern);
			company.setStockValue(extract_precio_accion(ParsingUtils.precio_accion_pattern));
			
			company.setRecomendacionBuy(extract_recomendacion(recomendacion_buy));
			company.setRecomendacionOutPerform(extract_recomendacion(recomendacion_outperform));
			company.setRecomendacionHold(extract_recomendacion(recomendacion_hold));
			company.setRecomendacionUnderPerform(extract_recomendacion(recomendacion_underperform));
			company.setRecomendacionSell(extract_recomendacion(recomendacion_sell));
			company.setRecomendacionNoOpinion(extract_recomendacion(recomendacion_no_opinion));
			company.generateOpinionAverage();
			company.setVolumenNegociado(extract_volumen_negociado(ParsingUtils.volumen_negociado));
			company.setFechaCreacion(cal.getTime());
			
			
			
			
			System.out.println("equity symbol: "+company.getTicker()+":"+company.getMarket()+"   "+data);
			System.out.println(countDownLatch.getCount());
			
		}catch (BusinessException e) {
			System.out.println(e.getMessage());
			queryLog.setForecastFail(queryLog.getForecastFail()+1);
			
		}catch (NumberFormatException e) {
			
			System.out.println("NumberFormatException en "+company.toString());
			queryLog.setForecastFail(queryLog.getForecastFail()+1);
			
			e.printStackTrace();
		}catch (NullPointerException e) {
			
			System.out.println("error en "+company.toString());
			queryLog.setForecastFail(queryLog.getForecastFail()+1);
			
			e.printStackTrace();
		}catch (IllegalStateException e) {
			
			System.out.println("error en "+data);
			queryLog.setForecastFail(queryLog.getForecastFail()+1);
			
			e.printStackTrace();
		}  catch (InterruptedException e) {
			queryLog.setForecastFail(queryLog.getForecastFail()+1);
			
			e.printStackTrace();
		} catch (Exception e) {
			queryLog.setForecastFail(queryLog.getForecastFail()+1);
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			countDownLatch.countDown();
		}
		
		
		
		
		System.out.println("Finished");
	}


}
