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

	int CONCURRENT_THREADS = 150;
	
	public List<Company> createCompanies(CompanyJson[] companyArray){
		List<Company> list = new ArrayList<Company>();
		
		Company company = null;
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
/*
class Equity implements Comparable<Equity>{
	String symbol;
	String market;
	String description;
	Double maxForecastValue;
	Double medForecastValue;
	Double minForecastValue;
	
	public Equity(String symbol,String market){
		this.symbol=symbol;
		this.market=market;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((market == null) ? 0 : market.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equity other = (Equity) obj;
		if (market == null) {
			if (other.market != null)
				return false;
		} else if (!market.equals(other.market))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}

	@Override
	public int compareTo(Equity o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Equity [symbol=" + symbol + ", market=" + market
				+ ", description=" + description + ", maxForecastValue="
				+ maxForecastValue + ", medForecastValue=" + medForecastValue
				+ ", minForecastValue=" + minForecastValue + "]";
	}
	
	
}
*/

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
