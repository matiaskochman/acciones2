package com.prediccion.acciones2.process;

import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
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
	
	Pattern recomendacion_buy = Pattern.compile("Buy"+ParsingUtils.common);
	Pattern recomendacion_outperform = Pattern.compile("Outperform"+ParsingUtils.common);
	Pattern recomendacion_hold = Pattern.compile("Hold"+ParsingUtils.common);
	Pattern recomendacion_underperform = Pattern.compile("Underperform"+ParsingUtils.common);
	Pattern recomendacion_sell = Pattern.compile("Underperform"+ParsingUtils.common);
	Pattern recomendacion_no_opinion = Pattern.compile("No opinion"+ParsingUtils.common);
			
	//Set<Company> treeSet;

	BlockingQueue<Company> queue;
	
	public Processor(CountDownLatch countDownLatch,Company company,BlockingQueue<Company> queue,Calendar cal, QueryLog queryLog) {
		super();
		this.company=company;
		this.countDownLatch = countDownLatch;
		this.queue = queue;
		this.cal = cal;
		this.queryLog = queryLog;
	}

	@Override
	public void run() {
		try {
			
			final String fullUrlStr = ParsingUtils.getFullUrl(this.company);
			
			data = HttpConectionUtils.getData(fullUrlStr);
			
			/*
			LogCompanyQuery logCompanyQuery = new LogCompanyQuery();
			
			logCompanyQuery.setQuery(financialTimes);
			logCompanyQuery.setQueryResult(data);
			
			logCompanyQuery.persist();
			*/
			
			ParsingUtils.extract_forecast_porcentaje(data, company);
			
			 

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
			
			queue.add(company);
			System.out.println("parseo nro: "+queue.size());
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
			e.printStackTrace();
		}finally{
			
			countDownLatch.countDown();
		}
		
		
	}



}
