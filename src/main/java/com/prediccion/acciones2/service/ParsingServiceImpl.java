package com.prediccion.acciones2.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.prediccion.acciones2.service.ParsingService;
import com.prediccion.acciones2.domain.Company;
import com.prediccion.acciones2.process.Processor;
import com.prediccion.acciones2.service.ColumnJson;
import com.prediccion.acciones2.service.CompanyJson;
import com.prediccion.acciones2.utils.HttpConectionUtils;

@Service
@Transactional
public class ParsingServiceImpl implements ParsingService{

	int CONCURRENT_THREADS = 200;
	
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
	
	public String buildQueryForLondon(String numberOfCompanies){
		
    	String num=null;
		
    	if(numberOfCompanies==null){
    		num="20";
    	}else{
    		num=numberOfCompanies;
    	}
		
		String price_change_52week="-101";
    	String london_stock_market = "exchange%20%3D%3D%20%22LON%22%29%20%26%20%28";
    	String london_query = "https://www.google.com/finance?output=json&start=0&"
    			+ "num="+num
    			+ "&noIL=1&q=[%28"
    			+ london_stock_market
    			+ "market_cap%20%3E%3D%200%29%20%26%20%28"
    			+ "market_cap%20%3C%3D%20221450000000%29%20%26%20%28"
    			+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
    			+ "pe_ratio%20%3C%3D%20250667%29%20%26%20%28"
    			+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
    			+ "dividend_yield%20%3C%3D%20141%29%20%26%20%28"
    			+ "price_change_52week%20%3E%3D%20-101%29%20%26%20%28"
    			+ "price_change_52week%20%3C%3D%20981%29"
    			+ "]&restype=company&ei=0NA7VZHHLOuJsge4_YHQBw"
    			+"&sortas=Price52WeekPercChange";
    	
    	return london_query;
		
	}
	
	
	public String buildQueryForParis(String numberOfCompanies){
		
		String paris_stock_market = "exchange%20%3D%3D%20%22EPA%22%29%20%26%20%28";
		String paris_price_change_52weeks = "-101";
    	String num=null;
    	
    	if(numberOfCompanies==null){
    		num="20";
    	}else{
    		num=numberOfCompanies;
    	}
    	
		String paris_query = "https://www.google.com/finance?output=json&start=0&"
				+ "num="+num
				+ "&noIL=1&q=[%28"
				+ paris_stock_market
				+ "market_cap%20%3E%3D%200%29%20%26%20%28"
				+ "market_cap%20%3C%3D%20127180000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%2010098%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%20171%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20"+paris_price_change_52weeks+"%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%201010%29]&restype=company&ei=jfs2VZHuH-zwsQfMhoCAAw&"+
				"sortas=Price52WeekPercChange";
				//"sortas=MarketCap";
		
		return paris_query;
	}
	
	public String buildQueryForUS(String numberOfCompanies){
		
    	String num=null;
    	
    	if(numberOfCompanies==null){
    		num="20";
    	}else{
    		num=numberOfCompanies;
    	}
    	
		String price_change_52week_from = "-101";
		String marketCap_from = "1000000";
		String nasdaq = "exchange%20%3D%3D%20%22NASDAQ%22%29%29%20%26%20%28";
		String nysemkt = "exchange%20%3D%3D%20%22NYSEMKT%22%29%20%7C%20%28";
		String nyse = "exchange%20%3D%3D%20%22NYSE%22%29%20%7C%20%28"; 
		String tcbb = "exchange%20%3D%3D%20%22OTCBB%22%29%20%7C%20%28";
		String currency = "currency%20%3D%3D%20%22USD%22%20%26%20%28%28";
		String nyseArca = "exchange%20%3D%3D%20%22NYSEARCA%22%29%20%7C%20%28";
		String otcmkt = "exchange%20%3D%3D%20%22OTCMKTS%22%29%20%7C%20%28";
		
		String us_query = "http://www.google.com/finance?"+
						"output=json&start=0&num="+num+"&noIL=1&q=["+
						currency+
						otcmkt+
						tcbb+
						nysemkt+
						nyseArca+
						nyse+
						nasdaq+
						"market_cap%20%3E%3D%20"+marketCap_from+"%29%20%26%20%28"+
						"market_cap%20%3C%3D%20726640000000%29%20%26%20%28"+
						"pe_ratio%20%3E%3D%2010%29%20%26%20%28"+
						"pe_ratio%20%3C%3D%2078.57%29%20%26%20%28"+
						"dividend_yield%20%3E%3D%200%29%20%26%20%28"+
						"dividend_yield%20%3C%3D%201976%29%20%26%20%28"+
						"price_change_52week%20%3E%3D%20"+price_change_52week_from+"%29%20%26%20%28"+
						"price_change_52week%20%3C%3D%2019901%29]&"+
						"restype=company&"+
						"ei=9LIzVcHMJcmUsQeLtoDQDw"+
						"&sortas=Price52WeekPercChange";
						//"&sortas=MarketCap";
		
		return us_query;
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
			
			for (Company company : companyList) {
				executorService.submit(new Processor(countDownLatch,company,resultSet));
			}
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			executorService.shutdown();
			
		} catch (Exception e) {
			e.printStackTrace();
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
