package com.prediccion.acciones2.utils;

import java.util.HashSet;
import java.util.Set;

public class ErrorCounterService {

	private Set<Long> ids_52_weeks_price_change_set = new HashSet<Long>();
	private Integer counter_52_weeks_price_change = 0;
	
	
	public Set<Long> getIds_52_weeks_price_change_set() {
		return ids_52_weeks_price_change_set;
	}
	public void setIds_52_weeks_price_change_set(
			Set<Long> ids_52_weeks_price_change_set) {
		this.ids_52_weeks_price_change_set = ids_52_weeks_price_change_set;
	}
	public Integer getCounter_52_weeks_price_change() {
		return counter_52_weeks_price_change;
	}
	public void setCounter_52_weeks_price_change(
			Integer counter_52_weeks_price_change) {
		this.counter_52_weeks_price_change = counter_52_weeks_price_change;
	}
	
	
}
