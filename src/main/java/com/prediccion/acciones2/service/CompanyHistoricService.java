package com.prediccion.acciones2.service;
import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

import com.prediccion.acciones2.domain.Company;

@RooService(domainTypes = { com.prediccion.acciones2.domain.CompanyHistoric.class })
public interface CompanyHistoricService {
	
	public void createHistotic(List<Company> companyList);
	public void createHistoricForCompany(Company company);
}
