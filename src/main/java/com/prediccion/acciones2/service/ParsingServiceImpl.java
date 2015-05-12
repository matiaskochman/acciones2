package com.prediccion.acciones2.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.prediccion.acciones2.domain.Company;
import com.prediccion.acciones2.domain.QueryLog;
import com.prediccion.acciones2.process.Processor;
import com.prediccion.acciones2.utils.HttpConectionUtils;

@Service
@Transactional
public class ParsingServiceImpl implements ParsingService{

	int CONCURRENT_THREADS = 180;

    @Autowired
    QueryLogService queryLogService;
	
	public List<Company> createCompanies(CompanyJson[] companyArray){
		List<Company> list = new ArrayList<Company>();
		
		Company company = null;
		if(companyArray!=null || companyArray.length==0){
			System.out.println("no hay datos para este mercado");
		}
		
		for (CompanyJson c : companyArray) {
			
			company = new Company();
			
			company.setTitle(c.title);
			company.setTicker(c.ticker);
			company.setExchange(c.exchange);
			company.setCompanyId(c.id);
			company.setLocalCurrencySymbol(c.local_currency_symbol);
			
			for (ColumnJson col : c.columns) {

				try{
					if(StringUtils.isEmpty(col.field)||StringUtils.isEmpty(col.value)){
						throw new Exception();
					}else{
						if(col.field.equalsIgnoreCase("MarketCap")){
							if(col.value.contains("B")){
								int i = col.value.indexOf("B");
								String sub1 = col.value.substring(0,i);
								Double val = Double.valueOf(sub1)*1000000000D;
								col.value = val.toString();
							}
							company.setMarketCap(Double.valueOf(col.value));
						}else if(col.field.equalsIgnoreCase("PE")){
							company.setPe(Double.valueOf(col.value));
							
						}else if(col.field.equalsIgnoreCase("Price52WeekPercChange")){
							company.setPrice52WeekPercChange(Double.valueOf(col.value));
							
						}
					}
					
				}catch(NumberFormatException e){
					System.out.println("numberFormatException property skipped");
				}catch(Exception e){
					e.printStackTrace();
					System.out.println("field or value empty property skipped");
				}
			}
			list.add(company);
		}
		return list;
	}
	
	
	public Set<Company> getSocksFromGoogleFinance(String query){
		List<Company> companyList = null;
		
		String result="";
		Comparator<Company> minComparator = new Comparator<Company>(){
			@Override
			public int compare(Company o1, Company o2) {
				int min = o1.getMinForecastPercentageValue().compareTo(o2.getMinForecastPercentageValue());
				return min*(-1);
			}
		};		    
		TreeSet<Company> resultSet = new TreeSet<Company>(minComparator);

		QueryLog queryLog = new QueryLog();

		
		try {
			Pattern p_european = Pattern.compile("\\[\\{\"title\"+[\\x00-\\x7F|€|£]+(?=\\,\\\"mf_searchresults)");
			
			result = HttpConectionUtils.getData(query);
			
			System.out.println(result);
			Matcher m = p_european.matcher(result);

			CompanyJson[] companyArray = null;
			if(m.find()){
				String sub = result.substring(m.start(),m.end());
				System.out.println(sub);
				Gson gson = new Gson();
				companyArray = gson.fromJson(sub, CompanyJson[].class);			
				System.out.println(sub);
			}else{
				System.out.println("no encontro "+"\\[\\{(\"title\")+[\\x00-\\x7F]+(?=\\,\\\"mf_searchresults)");
			}
			
		    companyList = createCompanies(companyArray);
		    
			CountDownLatch countDownLatch=new CountDownLatch(companyList.size());
			ExecutorService executorService=Executors.newFixedThreadPool(CONCURRENT_THREADS);
			
			Calendar cal = Calendar.getInstance();
			cal.clear(Calendar.MILLISECOND);
			cal.clear(Calendar.SECOND);
			cal.clear(Calendar.MINUTE);
			cal.clear(Calendar.HOUR);
			cal.clear(Calendar.HOUR_OF_DAY);
			
			try {
				for (Company company : companyList) {
					executorService.submit(new Processor(countDownLatch,company,resultSet,cal,queryLog));
				}
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				
				executorService.shutdown();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String market=null;
		if(resultSet!=null && !resultSet.isEmpty()){
			market = resultSet.iterator().next().getExchange();
			queryLog.setFechaQuery(new Date());
			queryLog.setForecastOk(String.valueOf(resultSet.size()));
			queryLog.setMarket(market);
			queryLogService.saveQueryLog(queryLog);
		}

		return resultSet;
	}

	
}

class CompanyJson {
	
	String title;
	String id;
	String is_active;
	String ticker;
	String exchange;
	String is_supported_exchange;
	String local_currency_symbol;
	ArrayList<ColumnJson> columns;
	
}
class ColumnJson{
	String display_name;
	String value;
	String field;
	String sort_order;
}
