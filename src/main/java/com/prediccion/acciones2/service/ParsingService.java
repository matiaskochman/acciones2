package com.prediccion.acciones2.service;

import java.util.Set;

import com.prediccion.acciones2.domain.Company;

public interface ParsingService {
	public Set<Company> getSocksFromGoogleFinance(String address,Integer amountOfThreads);
	
}
