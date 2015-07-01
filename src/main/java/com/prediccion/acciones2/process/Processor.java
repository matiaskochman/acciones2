package com.prediccion.acciones2.process;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.prediccion.acciones2.domain.Company;
import com.prediccion.acciones2.domain.LogCompanyQuery;
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
	
	Pattern recomendacion_buy = Pattern.compile("Buy"+ParsingUtils.common);
	Pattern recomendacion_outperform = Pattern.compile("Outperform"+ParsingUtils.common);
	Pattern recomendacion_hold = Pattern.compile("Hold"+ParsingUtils.common);
	Pattern recomendacion_underperform = Pattern.compile("Underperform"+ParsingUtils.common);
	Pattern recomendacion_sell = Pattern.compile("Underperform"+ParsingUtils.common);
	Pattern recomendacion_no_opinion = Pattern.compile("No opinion"+ParsingUtils.common);
			
	Set<Company> treeSet;

	public Processor(CountDownLatch countDownLatch,Company company,Set<Company> set,Calendar cal, QueryLog queryLog) {
		super();
		this.company=company;
		this.countDownLatch = countDownLatch;
		this.treeSet = set;
		this.cal = cal;
		this.queryLog = queryLog;
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
			
			/*
			LogCompanyQuery logCompanyQuery = new LogCompanyQuery();
			
			logCompanyQuery.setQuery(financialTimes);
			logCompanyQuery.setQueryResult(data);
			
			logCompanyQuery.persist();
			*/
			
			ParsingUtils.extract_forecast_porcentaje(data, company);
			
			treeSet.add(company);
			 
			System.out.println("parseo nro: "+treeSet.size());

			ParsingUtils.extract_recommendationsPopup_lastYear(data, company);
			
			ParsingUtils.extract_recommendationsPopup_last3months(data, company);
			
			ParsingUtils.extract_recommendationsPopup_last2months(data, company);
			
			ParsingUtils.extract_recommendationsPopup_last4weeks(data, company);
			
			/*
			if(company.getMinForecastPercentageValue()==null){
				throw new BusinessException("no pudo parsear los valores de forecast para "+company.getTicker()+":"+company.getExchange()+" "+
			"countdownlatch: "+countDownLatch.getCount());
			}
			*/
			ParsingUtils.extract_forecast_valoresAbsolutos(ParsingUtils.forecast_valores_pattern,data,company);
			
			company.setStockValue(ParsingUtils.extract_precio_accion(ParsingUtils.precio_accion_pattern,data,company));
			
			company.setRecomendacionBuy(ParsingUtils.extract_recomendacion(recomendacion_buy,data,company));
			company.setRecomendacionOutPerform(ParsingUtils.extract_recomendacion(recomendacion_outperform,data,company));
			company.setRecomendacionHold(ParsingUtils.extract_recomendacion(recomendacion_hold,data,company));
			company.setRecomendacionUnderPerform(ParsingUtils.extract_recomendacion(recomendacion_underperform,data,company));
			company.setRecomendacionSell(ParsingUtils.extract_recomendacion(recomendacion_sell,data,company));
			company.setRecomendacionNoOpinion(ParsingUtils.extract_recomendacion(recomendacion_no_opinion,data,company));
			company.generateOpinionAverage();
			company.setVolumenNegociado(ParsingUtils.extract_volumen_negociado(ParsingUtils.volumen_negociado,data,company));
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
		
		
	}


}
