package com.prediccion.acciones2.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.prediccion.acciones2.domain.Company;
import com.prediccion.acciones2.exception.BusinessException;

public class ParsingUtils {
	public static final Pattern forecast_porcentaje_pattern = Pattern.compile("-*\\d+(.)\\d*\\s*%");
	public static final Pattern forecast_valores_pattern = Pattern.compile("\\\"td\\\":\\[\\\"\\d+(?:.\\d+)\\\".\"\\d+(?:.\\d+)\\\".\"\\d+(?:.\\d+)\\\"\\]");
	public static final Pattern precio_accion_pattern = Pattern.compile("lastPrice.{37}\\\"content\\\":\\\"\\d+(?:.\\d+)\\\"|\\\"results\\\":.{8}\\[\\\"\\d+(?:.\\d+)\\\"");
	public static final Pattern volumen_negociado = Pattern.compile("volume_magnitude\\\".\\\"content\\\":\\\"\\d+(?:.\\d*)[km]");
	
	public static final Pattern recomendations_popup_last_year = Pattern.compile("Last\\syear(.*?).<.table><.div>");
	public static final Pattern recomendations_popup_3_months = Pattern.compile("3\\smonths\\sago(.*?).<.table><.div>");
	public static final Pattern recomendations_popup_2_months = Pattern.compile("2\\smonths\\sago(.*?).<.table><.div>");
	public static final Pattern recomendations_popup_4_weeks = Pattern.compile("4\\sweeks\\sago(.*?).<.table><.div>");
	
	public static final Pattern recomentations_buy = Pattern.compile("Buy(.*?)\\d");
	public static final Pattern recomentations_outperform = Pattern.compile("Outperform(.*?)\\d");
	public static final Pattern recomentations_hold = Pattern.compile("Hold(.*?)\\d");
	public static final Pattern recomentations_underperform = Pattern.compile("Underperform(.*?)\\d");
	public static final Pattern recomentations_sell = Pattern.compile("Sell(.*?)\\d");

	public static final Pattern number = Pattern.compile("\\d+");
	public static final String common = "\\\"}..\\\"class\\\":\\\"value\\\",((\\\"style\\\":\\\"color:.........\\\",\\\"content\\\":\\\"\\d+)|(\\\"content\\\":\\\"\\d+))";

	
	
	public static final String precioAccion = "//div[@class=\"contains wsodModuleContent\"]/table/tbody/tr/td[1]/span"; 
	public static final String porcentajeForecast = "//table[@class=\"fright\"]/tbody/tr/td[2]/span";
	public static final String sharesTraded = "//div[@class=\"contains wsodModuleContent\"]/table/tbody/tr/td[3]/span";
	public static final String valoresForecast = "//table[@class=\"fright\"]/tbody/tr/td[3]";
	
	public static final String latestRecomendations = "//div[@class=\"wsodRecommendationRating wsodModuleLastInGridColumn\"]/table";

	public static final String latestRecomentations_buy = "//body/script[text()[contains(.,\"Last year\")]]";
	
	//public static final Pattern recomentations_last_year_underperform = Pattern.compile("No\sopinion(.*?)\\d");

	
	public static void extract_recommendationsPopup_last4weeks(String data, Company company) throws Exception {
		Matcher m = ParsingUtils.recomendations_popup_4_weeks.matcher(data);
		 int start1 = 0;
		 int end1 = 0;

		 if(m.find()){
			 start1 = m.start();
			 end1 = m.end();
			 String val1 = data.substring(start1, end1);
			 
			 if(val1!=null && !val1.equals("")){
				 Matcher m_buy = ParsingUtils.recomentations_buy.matcher(val1);		 
				 Matcher m_hold = ParsingUtils.recomentations_hold.matcher(val1);		 
				 Matcher m_outperform = ParsingUtils.recomentations_outperform.matcher(val1);		 
				 Matcher m_sell = ParsingUtils.recomentations_sell.matcher(val1);		 
				 Matcher m_underperform = ParsingUtils.recomentations_underperform.matcher(val1);		 
				 
				 if(m_buy.find()){
					 String buy_string = val1.substring(m_buy.start(), m_buy.end());
					 
					 Matcher number_matcher = ParsingUtils.number.matcher(buy_string);
					 
					 if(number_matcher.find()){
						 company.setRecomendacionBuy_last_4weeks(Integer.valueOf(buy_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 if(m_hold.find()){
					 String hold_string = val1.substring(m_hold.start(), m_hold.end());
					 
					 Matcher number_matcher = ParsingUtils.number.matcher(hold_string);
					 
					 if(number_matcher.find()){
						 company.setRecomendacionHold_last_4weeks(Integer.valueOf(hold_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 if(m_outperform.find()){
					 String outperform_string = val1.substring(m_outperform.start(), m_outperform.end());
					 Matcher number_matcher = ParsingUtils.number.matcher(outperform_string);
					 if(number_matcher.find()){
						 company.setRecomendacionOutPerform_last_4weeks(Integer.valueOf(outperform_string.substring(number_matcher.start(), number_matcher.end())));
					 }
					 
				 }
				 if(m_sell.find()){
					 String sell_string = val1.substring(m_sell.start(), m_sell.end());
					 Matcher number_matcher = ParsingUtils.number.matcher(sell_string);
					 if(number_matcher.find()){
						 company.setRecomendacionSell_last_4weeks(Integer.valueOf(sell_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 if(m_underperform.find()){
					 String underperform_string = val1.substring(m_underperform.start(), m_underperform.end());
					 Matcher number_matcher = ParsingUtils.number.matcher(underperform_string);
					 if(number_matcher.find()){
						 company.setRecomendacionUnderPerform_last_4weeks(Integer.valueOf(underperform_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 
			 }
			 company.generateOpinionAverage_last_4weeks();
		 }else{
			 //System.out.println("error en recomendacion last 4 weeks, ticker: "+company.getTicker());
		 }
		 
		
	}
	
	public static void extract_recommendationsPopup_last2months(String data, Company company) throws Exception {
		Matcher m = ParsingUtils.recomendations_popup_2_months.matcher(data);
		 int start1 = 0;
		 int end1 = 0;

		 if(m.find()){
			 start1 = m.start();
			 end1 = m.end();
			 String val1 = data.substring(start1, end1);
			 
			 if(val1!=null && !val1.equals("")){
				 Matcher m_buy = ParsingUtils.recomentations_buy.matcher(val1);		 
				 Matcher m_hold = ParsingUtils.recomentations_hold.matcher(val1);		 
				 Matcher m_outperform = ParsingUtils.recomentations_outperform.matcher(val1);		 
				 Matcher m_sell = ParsingUtils.recomentations_sell.matcher(val1);		 
				 Matcher m_underperform = ParsingUtils.recomentations_underperform.matcher(val1);		 
				 
				 if(m_buy.find()){
					 String buy_string = val1.substring(m_buy.start(), m_buy.end());
					 
					 Matcher number_matcher = ParsingUtils.number.matcher(buy_string);
					 
					 if(number_matcher.find()){
						 company.setRecomendacionBuy_last_2months(Integer.valueOf(buy_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 if(m_hold.find()){
					 String hold_string = val1.substring(m_hold.start(), m_hold.end());
					 
					 Matcher number_matcher = ParsingUtils.number.matcher(hold_string);
					 
					 if(number_matcher.find()){
						 company.setRecomendacionHold_last_2months(Integer.valueOf(hold_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 if(m_outperform.find()){
					 String outperform_string = val1.substring(m_outperform.start(), m_outperform.end());
					 Matcher number_matcher = ParsingUtils.number.matcher(outperform_string);
					 if(number_matcher.find()){
						 company.setRecomendacionOutPerform_last_2months(Integer.valueOf(outperform_string.substring(number_matcher.start(), number_matcher.end())));
					 }
					 
				 }
				 if(m_sell.find()){
					 String sell_string = val1.substring(m_sell.start(), m_sell.end());
					 Matcher number_matcher = ParsingUtils.number.matcher(sell_string);
					 if(number_matcher.find()){
						 company.setRecomendacionSell_last_2months(Integer.valueOf(sell_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 if(m_underperform.find()){
					 String underperform_string = val1.substring(m_underperform.start(), m_underperform.end());
					 Matcher number_matcher = ParsingUtils.number.matcher(underperform_string);
					 if(number_matcher.find()){
						 company.setRecomendacionUnderPerform_last_2months(Integer.valueOf(underperform_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 
			 }
			 company.generateOpinionAverage_last_2months();
		 }else{
			 //System.out.println("no encontro recomendations_popup_2_months, ticker: "+company.getTicker());
		 }
		 
		
	}	
	
	public static void extract_recommendationsPopup_last3months(String data, Company company) throws Exception {
		Matcher m = ParsingUtils.recomendations_popup_3_months.matcher(data);
		 int start1 = 0;
		 int end1 = 0;

		 if(m.find()){
			 start1 = m.start();
			 end1 = m.end();
			 String val1 = data.substring(start1, end1);
			 
			 if(val1!=null && !val1.equals("")){
				 Matcher m_buy = ParsingUtils.recomentations_buy.matcher(val1);		 
				 Matcher m_hold = ParsingUtils.recomentations_hold.matcher(val1);		 
				 Matcher m_outperform = ParsingUtils.recomentations_outperform.matcher(val1);		 
				 Matcher m_sell = ParsingUtils.recomentations_sell.matcher(val1);		 
				 Matcher m_underperform = ParsingUtils.recomentations_underperform.matcher(val1);		 
				 
				 if(m_buy.find()){
					 String buy_string = val1.substring(m_buy.start(), m_buy.end());
					 
					 Matcher number_matcher = ParsingUtils.number.matcher(buy_string);
					 
					 if(number_matcher.find()){
						 company.setRecomendacionBuy_last_3months(Integer.valueOf(buy_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 if(m_hold.find()){
					 String hold_string = val1.substring(m_hold.start(), m_hold.end());
					 
					 Matcher number_matcher = ParsingUtils.number.matcher(hold_string);
					 
					 if(number_matcher.find()){
						 company.setRecomendacionHold_last_3months(Integer.valueOf(hold_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 if(m_outperform.find()){
					 String outperform_string = val1.substring(m_outperform.start(), m_outperform.end());
					 Matcher number_matcher = ParsingUtils.number.matcher(outperform_string);
					 if(number_matcher.find()){
						 company.setRecomendacionOutPerform_last_3months(Integer.valueOf(outperform_string.substring(number_matcher.start(), number_matcher.end())));
					 }
					 
				 }
				 if(m_sell.find()){
					 String sell_string = val1.substring(m_sell.start(), m_sell.end());
					 Matcher number_matcher = ParsingUtils.number.matcher(sell_string);
					 if(number_matcher.find()){
						 company.setRecomendacionSell_last_3months(Integer.valueOf(sell_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 if(m_underperform.find()){
					 String underperform_string = val1.substring(m_underperform.start(), m_underperform.end());
					 Matcher number_matcher = ParsingUtils.number.matcher(underperform_string);
					 if(number_matcher.find()){
						 company.setRecomendacionUnderPerform_last_3months(Integer.valueOf(underperform_string.substring(number_matcher.start(), number_matcher.end())));
					 }
				 }
				 
			 }
			 company.generateOpinionAverage_last_3months();
		 }else{
			 //System.out.println("no encontro recomendations_popup_3_months, ticker: "+company.getTicker());
		 }
		 
		
	}	
	
	public static void extract_recommendationsPopup_lastYear(String data, Company company) throws Exception {
		Matcher m = ParsingUtils.recomendations_popup_last_year.matcher(data);
		 int start1 = 0;
		 int end1 = 0;

		 if(m.find()){
			 start1 = m.start();
			 end1 = m.end();
			 String val1 = data.substring(start1, end1);
			 
			 if(val1!=null && !val1.equals("")){
				 Matcher m_buy = ParsingUtils.recomentations_buy.matcher(val1);		 
				 Matcher m_hold = ParsingUtils.recomentations_hold.matcher(val1);		 
				 Matcher m_outperform = ParsingUtils.recomentations_outperform.matcher(val1);		 
				 Matcher m_sell = ParsingUtils.recomentations_sell.matcher(val1);		 
				 Matcher m_underperform = ParsingUtils.recomentations_underperform.matcher(val1);		 
				 
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
			 company.generateOpinionAverage_last_year();
			 
		 }else{
			 System.out.println("no encontro recomendations_popup_last_year, ticker: "+company.getTicker());
		 }
		 
		
	}
	
	public static void extract_forecast_porcentaje(String data, Company company) throws Exception {
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
			 
			 try{
				 company.setMaxForecastPercentageValue(new Double(val1.replaceAll(",", "."))) ;
				 company.setMedForecastPercentageValue(new Double(val2.replaceAll(",", ".")));
				 company.setMinForecastPercentageValue(new Double(val3.replaceAll(",", ".")));
				 
				 
			 }catch(NumberFormatException e){
				 throw new BusinessException("problemas parseando max med y min forecast percentage values de ticker: "+company.getTicker());
			 }

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
		 }else{
			 throw new BusinessException("forecast_porcentaje_pattern fail");
			 //System.out.println("no encontro forecast_porcentaje_pattern");
		 }
	}
	public static void extract_forecast_valoresAbsolutos(Pattern forecast_valores_absolutos, String data, Company company) {
		
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
			
		 }else{
			 System.out.println("error en forecast valores absolutos, ticker: "+company.getTicker());
		 }
		
	}
	
	public static Double extract_precio_accion(Pattern p,String data,Company company){
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
			}else{
				System.out.println("error en precio accion, ticker: "+company.getTicker());
			}
		}else {
			System.out.println("yql extract -- la accion no tiene precio");
		}
		
		return -1D;
	}
	
	
	public static String extract_volumen_negociado(Pattern p,String data,Company company){
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
	
	public static Integer extract_recomendacion(Pattern p,String data,Company company){
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
			//System.out.println("no encontro valor de la recomendacion ");
		}
		return 0;
	}
	
	
	public static String getFullUrl(Company company) throws UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer();
		
		String baseUrl = "http://query.yahooapis.com/v1/public/yql?q=";
		
		final String financialTimes = "http://markets.ft.com/research/Markets/Tearsheets/Forecasts?s="+company.getTicker()+company.getMarket();
		
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
		return fullUrlStr;
	}
	
	
	
	
	
}
