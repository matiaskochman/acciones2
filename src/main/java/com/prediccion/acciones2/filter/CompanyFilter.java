package com.prediccion.acciones2.filter;

import com.prediccion.acciones2.domain.Company;

public class CompanyFilter {
	public static Boolean percentageForecastIntegrityValid(Company c){
		if(c.getMaxForecastPercentageValue()!=null && c.getMedForecastPercentageValue()!=null){
			if(c.getMaxForecastPercentageValue()<c.getMedForecastPercentageValue()){
				return false;
			}
			
			if(c.getMinForecastPercentageValue()!=null && c.getMedForecastPercentageValue()!=null){
				if(c.getMinForecastPercentageValue()>c.getMedForecastPercentageValue()){
					return false;
				}
			}
			if(c.getMaxForecastPercentageValue()!=null && c.getMinForecastPercentageValue()!=null){
				if(c.getMinForecastPercentageValue()>c.getMaxForecastPercentageValue()){
					return false;
				}
			}
			
		}
		return true;
	}
	
	public static Boolean percentageForecastNotEquals(Company c){
		 if(c.getMaxForecastPercentageValue()!=null||c.getMinForecastPercentageValue()!=null||c.getMedForecastPercentageValue()!=null){
			 
			 if(c.getMaxForecastPercentageValue().equals(c.getMinForecastPercentageValue())&&c.getMaxForecastPercentageValue().equals(c.getMedForecastPercentageValue())){
				 return false;
			 }
		 }
		return true;
	}
}
