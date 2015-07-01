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
	
	public static String buildQueryForLondon(String numberOfCompanies,String market_from,String market_to){
			
		String marketCap_from = "0";
		String marketCap_to ="202120000000";
		if(market_from != null && market_to !=null){
			marketCap_from = market_from;
			marketCap_to = market_to;
		}		
			
    	String num=null;
		
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
		
		String price_change_52week="-101";
    	
    	
    	String london_query = "https://www.google.com/finance?output=json&start=0&"
    			+ "num="+num
    			+ "&noIL=1&q=[%28"
    			+ "exchange%20%3D%3D%20%22LON"
    			+ "%22%29%20%26%20%28"
    			+ "market_cap%20%3E%3D%20"+marketCap_from
    			+ "%29%20%26%20%28"
    			+ "market_cap%20%3C%3D%20"+marketCap_to
    			+ "%29%20%26%20%28"
    			+ "pe_ratio%20%3E%3D%200"
    			+ "%29%20%26%20%28"
    			+ "pe_ratio%20%3C%3D%20250667"
    			+ "%29%20%26%20%28"
    			+ "dividend_yield%20%3E%3D%200"
    			+ "%29%20%26%20%28"
    			+ "dividend_yield%20%3C%3D%20141"
    			+ "%29%20%26%20%28"
    			+ "price_change_52week%20%3E%3D%20-99.11"
    			+ "%29%20%26%20%28"
    			+ "price_change_52week%20%3C%3D%201358"
    			+ "%29]&restype=company&ei=uzyAVenlNIePmAGrlICYAQ&";
    			//+ "sortas=MarketCap";
    	
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
	
	public static String buildQueryForUS(String numberOfCompanies,String market_from,String market_to){
		
		String marketCap_from = "1000000";
		String marketCap_to ="7266400000";
		if(market_from != null && market_to !=null){
			marketCap_from = market_from;
			marketCap_to = market_to;
		}
		
    	String num=null;
    	
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	
    	String ei="xk-JVfCDOJDDe6aWp0A";
    	String dividend_from = "0";
    	String dividend_to="30";
		String price_change_52week_from = "-101";
		String price_change_52week_to = "50901";
		String pe_from = "0";
		String pe_to = "10465";
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
						//otcmkt+
						//tcbb+
						//nysemkt+
						//nyseArca+
						nyse+
						nasdaq+
						"market_cap%20%3E%3D%20"+marketCap_from+"%29%20%26%20%28"+
						"market_cap%20%3C%3D%20"+marketCap_to
						+ "%29%20%26%20%28"+
						"pe_ratio%20%3E%3D%20"+pe_from
						+ "%29%20%26%20%28"+
						"pe_ratio%20%3C%3D%20"+pe_to
						+ "%29%20%26%20%28"+
						"dividend_yield%20%3E%3D%200%29%20%26%20%28"+
						"dividend_yield%20%3C%3D%203900000%29%20%26%20%28"+
						"price_change_52week%20%3E%3D%20"+price_change_52week_from+"%29%20%26%20%28"+
						"price_change_52week%20%3C%3D%20"+price_change_52week_to
						+ "%29]&"+
						"restype=company&"+
						"ei="+ei;
						//+"&sortas=MarketCap";
		
		System.out.println(us_query);
		return us_query;
	}
	public static String buildQueryForGermany(String numberOfCompanies) {
    	String num=null;
    	
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	String marketCapitalFrom = "10000";

		String query = "https://www.google.com/finance?output=json&start=0&"
				+ "num="+num
				+ "&noIL=1&q=[%28%28"
				+ "exchange%20%3D%3D%20%22ETR%22%29%20%7C%20%28"
				+ "exchange%20%3D%3D%20%22FRA%22%29%29%20%26%20%28"
				+ "market_cap%20%3E%3D%20"+marketCapitalFrom
				+ "%29%20%26%20%28"
				+ "market_cap%20%3C%3D%20109270000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%205130000%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%20227%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20-99.91%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%204105%29]&"
				+ "restype=company&ei=_NBEVYGRJMS0sQerq4DwBw&";
				//+ "sortas=MarketCap";		
		
		return query;
	}

	public static String buildQueryForCanada(String numberOfCompanies) {
		
    	String num=null;
    	
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	String marketCapitalFrom = "10000";

		String query = "https://www.google.com/finance?output=json&start=0"+
						"&num="+num+
						"&noIL=1&q=[%28%28"+
						"exchange%20%3D%3D%20%22TSE%22%29%20%7C%20%28"+
						"exchange%20%3D%3D%20%22CVE%22%29%20%7C%20%28"+
						"exchange%20%3D%3D%20%22CNSX%22%29%29%20%26%20%28"+
						"market_cap%20%3E%3D%20"+marketCapitalFrom
						+ "%29%20%26%20%28"+
						"market_cap%20%3C%3D%209310000000000%29%20%26%20%28"+
						"pe_ratio%20%3E%3D%200%29%20%26%20%28"+
						"pe_ratio%20%3C%3D%202096%29%20%26%20%28"+
						"dividend_yield%20%3E%3D%200%29%20%26%20%28"+
						"dividend_yield%20%3C%3D%201921%29%20%26%20%28"+
						"price_change_52week%20%3E%3D%20-99.97%29%20%26%20%28"+
						"price_change_52week%20%3C%3D%201334%29]&restype=company&ei=kBhCVenZONLJsQfMuoGgDA&";
						//+"sortas=MarketCap";
		
		return query;
	}
	public static String buildQueryForSpain(String numberOfCompanies) {

    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	String marketCapitalFrom = "10000";
    	
		String query = "https://www.google.com/finance?output=json&start=0&"
				+ "num="+num
				+ "&noIL=1&q=["
				+ "currency%20%3D%3D%20%22EUR%22%20%26%20%28"
				+ "exchange%20%3D%3D%20%22BME%22%29%20%26%20%28"
				+ "market_cap%20%3E%3D%20"+marketCapitalFrom
				+ "%29%20%26%20%28"
				+ "market_cap%20%3C%3D%2097060000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%20273%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%2084.17%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20-67.16%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%20180%29]&restype=company&ei=_NBEVYGRJMS0sQerq4DwBw&";
				//+ "sortas=MarketCap";		
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
    			+ "price_change_52week%20%3C%3D%20122%29]&restype=company&ei=sWRHVdmSDPTisQfXjYDwDw&";
    			//+ "sortas=MarketCap";
    	
		return query;
	}

	public static String buildQueryForBelgium(String numberOfCompanies){
		
    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	
    	String marketCapitalFrom = "10000";
		String query = "https://www.google.com/finance?output=json&"
				+ "start=0"
				+ "&num="+num
				+ "&noIL=1&q=[%28"
				+ "exchange%20%3D%3D%20%22EBR%22%29%20%26%20%28"
				+ "market_cap%20%3E%3D%20"+marketCapitalFrom+"%29%20%26%20%28"
				+ "market_cap%20%3C%3D%20172220000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%2012594%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%2017.35%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20-92.73%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%20645%29]&"
				+ "restype=company&ei=lFxTVZmhHNb_mAHZiYGQCw&";
				//+ "sortas=MarketCap";
		
		return query;
	}
	
	public static String buildQueryForNetherlands(String numberOfCompanies){
    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	
    	String marketCapitalFrom = "10000";		
		String query = "https://www.google.com/finance?output=json&"
				+ "start=0&"
				+ "num=20"
				+ "&noIL=1&q=[%28"
				+ "exchange%20%3D%3D%20%22AMS%22%29%20%26%20%28"
				+ "market_cap%20%3E%3D%20"+marketCapitalFrom
				+ "%29%20%26%20%28"
				+ "market_cap%20%3C%3D%20179560000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%20553%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%208.69%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20-95.01%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%20142%29]&restype=company&ei=lFxTVZmhHNb_mAHZiYGQCw&";
				//+ "sortas=MarketCap";
		
		return query;
	}
	public static String buildQueryForAustralia(String numberOfCompanies){
		
    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	
    	String marketCapitalFrom = "10000";		
		String query = "https://www.google.com/finance?output=json&"
				+ "start=0"
				+ "&num="+num
				+ "&noIL=1&q=["
				+ "currency%20%3D%3D%20%22AUD%22%20%26%20%28"
				+ "exchange%20%3D%3D%20%22ASX%22%29%20%26%20%28"
				+ "market_cap%20%3E%3D%20"+marketCapitalFrom
				+ "%29%20%26%20%28"
				+ "market_cap%20%3C%3D%20166770000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%203161%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%2040.93%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20-97.93%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%2063901%29]&restype=company&ei=YIRUVYj2OeCEeZrHgIAC&";
				//+ "sortas=MarketCap";
		
		return query;
	}
	
	
	public static String buildQueryForNewZeland(String numberOfCompanies){
		
    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	
    	String marketCapitalFrom = "10000";			
		
		String query ="https://www.google.com/finance?output=json&start=0&"
				+ "num="+num
				+ "&noIL=1&q=["
				+ "currency%20%3D%3D%20%22NZD%22%20%26%20%28"
				+ "exchange%20%3D%3D%20%22NZE%22%29%20%26%20%28"
				+ "market_cap%20%3E%3D%20"+marketCapitalFrom
				+ "%29%20%26%20%28"
				+ "market_cap%20%3C%3D%207970000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%20578%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%2015.14%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20-94.97%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%20512%29]&restype=company&ei=TSlVVbnDG4eVe_mogcAB&";
				//+ "sortas=MarketCap";
	
		
		return query;
	}
	
	public static String buildQueryForTaiwan(String numberOfCompanies){
    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	String marketCapitalFrom = "1000000";			
		String query = "https://www.google.com/finance?output=json&start=0&"
				+ "num="+num
				+ "&noIL=1&q=["
				+ "currency%20%3D%3D%20%22TWD%22%20%26%20%28"
				+ "exchange%20%3D%3D%20%22TPE%22%29%20%26%20%28"
				+ "market_cap%20%3E%3D%20"+marketCapitalFrom
				+ "%29%20%26%20%28"
				+ "market_cap%20%3C%3D%203800000000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%203660%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%2056.03%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20-82.24%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%202372%29]&restype=company&ei=V5hcVaG8IMXcmAHK8ICwCg&";
				//+ "sortas=MarketCap";
		
		return query;
	}
	public static String buildQueryForSingapore(String numberOfCompanies){
    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	String marketCapitalFrom = "10000";			
		
		String query = "https://www.google.com/finance?output=json&start=0&"
				+ "num="+num
				+ "&noIL=1&q=[%28"
				+ "exchange%20%3D%3D%20%22SGX%22%29%20%26%20%28"
				+ "market_cap%20%3E%3D%20"+marketCapitalFrom
				+ "%29%20%26%20%28"
				+ "market_cap%20%3C%3D%2076360000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%206836%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%20219%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20-90.01%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%201123"
				+ "%29]&restype=company&ei=V5hcVaG8IMXcmAHK8ICwCg&";
				//+ "sortas=MarketCap";
		
		return query;
	}
	public static String buildQueryForJapan(String numberOfCompanies){
    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	String marketCapitalFrom = "1000000";			
		
		String query="https://www.google.com/finance?output=json&start=0&"
				+ "num="+num
				+ "&noIL=1&q=["
				+ "currency%20%3D%3D%20%22JPY%22%20%26%20%28"
				+ "exchange%20%3D%3D%20%22TYO%22%29%20%26%20%28"
				+ "market_cap%20%3E%3D%20"+marketCapitalFrom
				+ "%29%20%26%20%28"
				+ "market_cap%20%3C%3D%2028690000000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%202380000%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%2071.44%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20-99.91%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%201845"
				+ "%29]&restype=company&ei=V5hcVaG8IMXcmAHK8ICwCg&";
				//+ "sortas=MarketCap";
		
		return query;
	}
	public static String buildQueryForChina(String numberOfCompanies){
    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	String marketCapitalFrom = "1000000";
    	
    	String query = "https://www.google.com/finance?output=json&start=0&"
    			+ "num="+num
    			+ "&noIL=1&q=[%28%28"
    			+ "exchange%20%3D%3D%20%22SHE%22%29%20%7C%20%28"
    			+ "exchange%20%3D%3D%20%22SHA%22%29%29%20%26%20%28"
    			+ "market_cap%20%3E%3D%20"+marketCapitalFrom
    			+ "%29%20%26%20%28"
    			+ "market_cap%20%3C%3D%202069999999999.9998%29%20%26%20%28"
    			+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
    			+ "pe_ratio%20%3C%3D%2023951%29%20%26%20%28"
    			+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
    			+ "dividend_yield%20%3C%3D%205.13%29%20%26%20%28"
    			+ "price_change_52week%20%3E%3D%20-37.34%29%20%26%20%28"
    			+ "price_change_52week%20%3C%3D%201680%29]&restype=company&ei=V5hcVaG8IMXcmAHK8ICwCg&";
    			//+ "sortas=MarketCap";
    	
    	return query;
	}
	public static String buildQueryForSwitzerland(String numberOfCompanies){
    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	String marketCapitalFrom = "100000";
    	
    	String query="https://www.google.com/finance?output=json&start=0&"
    			+ "num="+num
    			+ "&noIL=1&q=[%28%28"
    			+ "exchange%20%3D%3D%20%22VTX%22%29%20%7C%20%28"
    			+ "exchange%20%3D%3D%20%22SWX%22%29%29%20%26%20%28"
    			+ "market_cap%20%3E%3D%20"+marketCapitalFrom
    			+ "%29%20%26%20%28"
    			+ "market_cap%20%3C%3D%20262860000000%29%20%26%20%28"
    			+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
    			+ "pe_ratio%20%3C%3D%20241%29%20%26%20%28"
    			+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
    			+ "dividend_yield%20%3C%3D%2016.19%29%20%26%20%28"
    			+ "price_change_52week%20%3E%3D%20-62.61%29%20%26%20%28"
    			+ "price_change_52week%20%3C%3D%20893%29]&restype=company&ei=V5hcVaG8IMXcmAHK8ICwCg&";
    			//+ "sortas=MarketCap";

    	return query;
	}
	public static String buildQueryForPoland(String numberOfCompanies){
		
    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	String marketCapitalFrom = "100000";
    	
		String query = "https://www.google.com/finance?output=json&start=0&"
				+ "num="+num
				+ "&noIL=1&q=["
				+ "currency%20%3D%3D%20%22PLN%22%20%26%20%28"
				+ "exchange%20%3D%3D%20%22WSE%22%29%20%26%20%28"
				+ "market_cap%20%3E%3D%20"+marketCapitalFrom
				+ "%29%20%26%20%28"
				+ "market_cap%20%3C%3D%2049190000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%202945%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%2089.13%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20-96.95%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%20289%29]&restype=company&ei=GspsVZnID8T4evyYg8gG&";
				//+ "sortas=MarketCap";
		
		
		return query;
	}
	public static String buildQueryForTurkey(String numberOfCompanies){
		
    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	String marketCapitalFrom = "100000";
    	
		String query = "https://www.google.com/finance?output=json&start=0&"
				+ "num="+num
				+ "&noIL=1&q=[currency%20%3D%3D%20%22TRY%22%20%26%20%28"
				+ "exchange%20%3D%3D%20%22IST%22%29%20%26%20%28"
				+ "market_cap%20%3E%3D%20"+marketCapitalFrom
				+ "%29%20%26%20%28"
				+ "market_cap%20%3C%3D%2035410000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%2020799%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%2022.24%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20-93.8%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%20489%29]&restype=company&ei=GspsVZnID8T4evyYg8gG&";
				//+ "sortas=MarketCap";
		
		return query;
	}
	public static String buildQueryForSweden(String numberOfCompanies){
		
    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	String marketCapitalFrom = "100000";
    	
    	String query = "https://www.google.com/finance?output=json&"
    			+ "start=0&"
    			+ "num="+num
    			+ "&noIL=1&q=[%28"
    			+ "exchange%20%3D%3D%20%22STO%22%29%20%26%20%28"
    			+ "market_cap%20%3E%3D%20"+marketCapitalFrom
    			+ "%29%20%26%20%28"
    			+ "market_cap%20%3C%3D%20491080000000%29%20%26%20%28"
    			+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
    			+ "pe_ratio%20%3C%3D%201301%29%20%26%20%28"
    			+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
    			+ "dividend_yield%20%3C%3D%2072.04%29%20%26%20%28"
    			+ "price_change_52week%20%3E%3D%20-95.27%29%20%26%20%28"
    			+ "price_change_52week%20%3C%3D%20313%29]&restype=company&ei=GspsVZnID8T4evyYg8gG&";
    			//+ "sortas=MarketCap";
    	
    	return query;
	}
	public static String buildQueryForSouthAfrica(String numberOfCompanies){
		
    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	String marketCapitalFrom = "100000";
    	
		String query = "https://www.google.com/finance?output=json&"
				+ "start=0&"
				+ "num="+num
				+ "&noIL=1&q=[%28"
				+ "currency%20%3D%3D%20%22ZAR%22%20%7C%20"
				+ "currency%20%3D%3D%20%22ZAC%22%29%20%26%20%28"
				+ "exchange%20%3D%3D%20%22JSE%22%29%20%26%20%28"
				+ "market_cap%20%3E%3D%20"+marketCapitalFrom
				+ "%29%20%26%20%28"
				+ "market_cap%20%3C%3D%201050000000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%209334%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%2089.3%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20-96.57%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%20436%29]&restype=company&ei=GspsVZnID8T4evyYg8gG&";
				//+ "sortas=MarketCap";
		
		return query;
	}
	public static String buildQueryForRussia(String numberOfCompanies){
    	String num=null;
    	if(numberOfCompanies==null){
    		num="10";
    	}else{
    		num=numberOfCompanies;
    	}
    	String marketCapitalFrom = "100000";		
		
		String query = "https://www.google.com/finance?output=json&start=0&"
				+ "num="+num
				+ "&noIL=1&q=[currency%20%3D%3D%20%22RUB%22%20%26%20%28"
				+ "exchange%20%3D%3D%20%22MCX%22%29%20%26%20%28"
				+ "market_cap%20%3E%3D%20"+marketCapitalFrom
				+ "%29%20%26%20%28"
				+ "market_cap%20%3C%3D%203300000000000%29%20%26%20%28"
				+ "pe_ratio%20%3E%3D%200%29%20%26%20%28"
				+ "pe_ratio%20%3C%3D%2065394%29%20%26%20%28"
				+ "dividend_yield%20%3E%3D%200%29%20%26%20%28"
				+ "dividend_yield%20%3C%3D%2025.75%29%20%26%20%28"
				+ "price_change_52week%20%3E%3D%20-86.7%29%20%26%20%28"
				+ "price_change_52week%20%3C%3D%20357%29]&restype=company&ei=GspsVZnID8T4evyYg8gG&";
				//+ "sortas=MarketCap";
		
		return query;
	}
}
