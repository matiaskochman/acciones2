package com.prediccion.acciones2.service;
import org.springframework.roo.addon.layers.service.RooService;

import com.prediccion.acciones2.domain.Company;

@RooService(domainTypes = { com.prediccion.acciones2.domain.Company.class })
public interface CompanyService {
	public void saveOrUpdate(Company c);
}
