package com.prediccion.acciones2.utils;

public class QueryBuilder {

	public static String buildQueryForItaly(String numberOfCompanies){
		
    	String num=null;
		
    	if(numberOfCompanies==null){
    		num="20";
    	}else{
    		num=numberOfCompanies;
    	}
		
		String query = "https://www.google.com/finance?output=json&start=0&"+
			"num="+num+
			"&noIL=1&q=["+
			"currency%20%3D%3D%20%22EUR%22%20%26%20%28"+
			"exchange%20%3D%3D%20%22BIT%22%29%20%26%20%28"+
			"market_cap%20%3E%3D%201420000%29%20%26%20%28"+
			"market_cap%20%3C%3D%2062440000000%29%20%26%20%28"+
			"pe_ratio%20%3E%3D%200%29%20%26%20%28"+
			"pe_ratio%20%3C%3D%20459%29%20%26%20%28"+
			"dividend_yield%20%3E%3D%200%29%20%26%20%28"+
			"dividend_yield%20%3C%3D%2011.31%29%20%26%20%28"+
			"price_change_52week%20%3E%3D%20-97.42%29%20%26%20%28"+
			"price_change_52week%20%3C%3D%20414%29]&"+
			"restype=company&ei=_NBEVYGRJMS0sQerq4DwBw&"+
			"sortas=MarketCap";
		
		return query;
	}
	
	public static String buildQueryForLondon(String numberOfCompanies){
		
    	String num=null;
		
    	if(numberOfCompanies==null){
    		num="10";
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
	
	
	public static String buildQueryForParis(String numberOfCompanies){
		
		String paris_stock_market = "exchange%20%3D%3D%20%22EPA%22%29%20%26%20%28";
		String paris_price_change_52weeks = "-101";
    	String num=null;
    	
    	if(numberOfCompanies==null){
    		num="10";
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
	
	public static String buildQueryForUS(String numberOfCompanies){
		
    	String num=null;
    	
    	if(numberOfCompanies==null){
    		num="10";
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
						"&sortas=MarketCap";
						//"&sortas=Price52WeekPercChange";
		
		return us_query;
	}
	public static String buildQueryForGermany(String numberOfCompanies) {
    	String num=null;
    	
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
		
		String query = "https://www.google.com/finance?output=json&start=0&"
				+ "num="+num
				+ "&noIL=1&q=[%28%28"
				+ "exchange%20%3D%3D%20%22ETR%22%29%20%7C%20%28"
				+ "exchange%20%3D%3D%20%22FRA%22%29%29%20%26%20%28"
				+ "market_cap%20%3E%3D%201420000%29%20%26%20%28"
				+ "market_cap%20%3C%3D%20109270000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%205130000%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%20227%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20-99.91%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%204105%29]&"
				+ "restype=company&ei=_NBEVYGRJMS0sQerq4DwBw&"
				+ "sortas=MarketCap";		
		
		return query;
	}

	public static String buildQueryForCanada(String numberOfCompanies) {
		
    	String num=null;
    	
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
		
		String query = "https://www.google.com/finance?output=json&start=0"+
						"&num="+num+
						"&noIL=1&q=[%28%28"+
						"exchange%20%3D%3D%20%22TSE%22%29%20%7C%20%28"+
						"exchange%20%3D%3D%20%22CVE%22%29%20%7C%20%28"+
						"exchange%20%3D%3D%20%22CNSX%22%29%29%20%26%20%28"+
						"market_cap%20%3E%3D%200.35%29%20%26%20%28"+
						"market_cap%20%3C%3D%209310000000000%29%20%26%20%28"+
						"pe_ratio%20%3E%3D%200%29%20%26%20%28"+
						"pe_ratio%20%3C%3D%202096%29%20%26%20%28"+
						"dividend_yield%20%3E%3D%200%29%20%26%20%28"+
						"dividend_yield%20%3C%3D%201921%29%20%26%20%28"+
						"price_change_52week%20%3E%3D%20-99.97%29%20%26%20%28"+
						"price_change_52week%20%3C%3D%201334%29]&restype=company&ei=kBhCVenZONLJsQfMuoGgDA&"+
						"sortas=MarketCap";
		
		return query;
	}
	public static String buildQueryForSpain(String numberOfCompanies) {

    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
		String query = "https://www.google.com/finance?output=json&start=0&"
				+ "num="+num
				+ "&noIL=1&q=["
				+ "currency%20%3D%3D%20%22EUR%22%20%26%20%28"
				+ "exchange%20%3D%3D%20%22BME%22%29%20%26%20%28"
				+ "market_cap%20%3E%3D%2017840000%29%20%26%20%28"
				+ "market_cap%20%3C%3D%2097060000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%20273%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%2084.17%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20-67.16%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%20180%29]&restype=company&ei=_NBEVYGRJMS0sQerq4DwBw&"
				+ "sortas=MarketCap";		
		return query;
	}

	public static String buildQueryForBrasil(String numberOfCompanies) {

    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	
    	String query = "https://www.google.com/finance?output=json&"
    			+ "start=0&"
    			+ "num="+num
    			+ "&noIL=1&q=["
    			+ "currency%20%3D%3D%20%22BRL%22%20%26%20%28"
    			+ "exchange%20%3D%3D%20%22BVMF%22%29%20%26%20%28"
    			+ "market_cap%20%3E%3D%200%29%20%26%20%28"
    			+ "market_cap%20%3C%3D%20297700000000%29%20%26%20%28"
    			+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
    			+ "pe_ratio%20%3C%3D%2023801%29%20%26%20%28"
    			+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
    			+ "dividend_yield%20%3C%3D%202097%29%20%26%20%28"
    			+ "price_change_52week%20%3E%3D%20-84.35%29%20%26%20%28"
    			+ "price_change_52week%20%3C%3D%20122%29]&restype=company&ei=sWRHVdmSDPTisQfXjYDwDw&"
    			+ "sortas=MarketCap";
    	
		return query;
	}

	
	
}
