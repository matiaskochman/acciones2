package com.prediccion.acciones2.service;

import java.util.Set;

import com.prediccion.acciones2.domain.Company;

public interface ParsingService {
	public Set<Company> getSocksFromGoogleFinance(String address);
	public String buildQueryForUS(String numberOfCompanies);
	public String buildQueryForParis(String numberOfCompanies);
	public String buildQueryForLondon(String numberOfCompanies);
	public String buildQueryForSpain(String numberOfCompanies);
	public String buildQueryForItaly(String numberOfCompanies);
	public String buildQueryForGermany(String numberOfCompanies);
	public String buildQueryForCanada(String numberOfCompanies);
	
}
