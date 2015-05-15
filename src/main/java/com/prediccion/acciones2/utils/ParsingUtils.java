package com.prediccion.acciones2.utils;

import java.util.regex.Pattern;

public class ParsingUtils {
	public static final Pattern forecast_porcentaje_pattern = Pattern.compile("-*\\d+(.)\\d*\\s*%");
	public static final Pattern forecast_valores_pattern = Pattern.compile("\\\"td\\\":\\[\\\"\\d+(?:.\\d+)\\\".\"\\d+(?:.\\d+)\\\".\"\\d+(?:.\\d+)\\\"\\]");
	public static final Pattern precio_accion_pattern = Pattern.compile("lastPrice.{37}\\\"content\\\":\\\"\\d+(?:.\\d+)\\\"|\\\"results\\\":.{8}\\[\\\"\\d+(?:.\\d+)\\\"");
	public static final Pattern volumen_negociado = Pattern.compile("volume_magnitude\\\".\\\"content\\\":\\\"\\d+(?:.\\d*)[km]");
	public static final String common = "\\\"}..\\\"class\\\":\\\"value\\\",((\\\"style\\\":\\\"color:.........\\\",\\\"content\\\":\\\"\\d+)|(\\\"content\\\":\\\"\\d+))";
	public static final String precioAccion = "//div[@class=\"contains wsodModuleContent\"]/table/tbody/tr/td[1]/span"; 
	public static final String porcentajeForecast = "//table[@class=\"fright\"]/tbody/tr/td[2]/span";
	public static final String sharesTraded = "//div[@class=\"contains wsodModuleContent\"]/table/tbody/tr/td[3]/span";
	public static final String valoresForecast = "//table[@class=\"fright\"]/tbody/tr/td[3]";
	
	public static final String latestRecomendations = "//div[@class=\"wsodRecommendationRating wsodModuleLastInGridColumn\"]/table";

	public static final String latestRecomentations_buy = "//<div class='recommendationsPopup'>.*Buy</td><td class='value'>\\d*";
}
