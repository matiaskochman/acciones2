package com.prediccion.acciones2.utils;

import java.util.regex.Pattern;

public class ParsingUtils {
	public static final Pattern forecast_porcentaje_pattern = Pattern.compile("-*\\d+(.)\\d*\\s*%");
	public static final Pattern forecast_valores_pattern = Pattern.compile("\\\"td\\\":\\[\\\"\\d+(?:.\\d+)\\\".\"\\d+(?:.\\d+)\\\".\"\\d+(?:.\\d+)\\\"\\]");
	public static final Pattern precio_accion_pattern = Pattern.compile("lastPrice.{37}\\\"content\\\":\\\"\\d+(?:.\\d+)\\\"|\\\"results\\\":.{8}\\[\\\"\\d+(?:.\\d+)\\\"");
	public static final Pattern volumen_negociado = Pattern.compile("volume_magnitude\\\".\\\"content\\\":\\\"\\d+(?:.\\d*)[km]");
	
	public static final Pattern recomendations_popup_last_year = Pattern.compile("Last\\syear(.*?).<.table><.div>");
	public static final Pattern recomentations_last_year_buy = Pattern.compile("Buy(.*?)\\d");
	public static final Pattern recomentations_last_year_outperform = Pattern.compile("Outperform(.*?)\\d");
	public static final Pattern recomentations_last_year_hold = Pattern.compile("Hold(.*?)\\d");
	public static final Pattern recomentations_last_year_underperform = Pattern.compile("Underperform(.*?)\\d");
	public static final Pattern recomentations_last_year_sell = Pattern.compile("Sell(.*?)\\d");

	public static final Pattern number = Pattern.compile("\\d+");
	
	public static final String common = "\\\"}..\\\"class\\\":\\\"value\\\",((\\\"style\\\":\\\"color:.........\\\",\\\"content\\\":\\\"\\d+)|(\\\"content\\\":\\\"\\d+))";
	public static final String precioAccion = "//div[@class=\"contains wsodModuleContent\"]/table/tbody/tr/td[1]/span"; 
	public static final String porcentajeForecast = "//table[@class=\"fright\"]/tbody/tr/td[2]/span";
	public static final String sharesTraded = "//div[@class=\"contains wsodModuleContent\"]/table/tbody/tr/td[3]/span";
	public static final String valoresForecast = "//table[@class=\"fright\"]/tbody/tr/td[3]";
	
	public static final String latestRecomendations = "//div[@class=\"wsodRecommendationRating wsodModuleLastInGridColumn\"]/table";

	public static final String latestRecomentations_buy = "//body/script[text()[contains(.,\"Last year\")]]";
	
	//public static final Pattern recomentations_last_year_underperform = Pattern.compile("No\sopinion(.*?)\\d");
 
}
