package com.prediccion.acciones2.service;

import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.prediccion.acciones2.domain.Company;
import com.prediccion.acciones2.domain.CompanyHistoric;

public class CompanyHistoricServiceImpl implements CompanyHistoricService {
	Mapper mapper = new DozerBeanMapper();

	@Override
	@Transactional
	public void createHistotic(List<Company> companyList) {
		
		CompanyHistoric ch = null;
		for (Company company : companyList) {
			ch = new CompanyHistoric();
			mapper.map(company, ch);
			ch.setId(null);
			ch.setVersion(null);
			ch.setFechaCreacion(new Date());
			ch.save();
		}
		/*
		for (Company company : companyList) {
			company.remove();
		}
		*/
	}


	@Override
	public void createHistoricForCompany(Company company) {
		CompanyHistoric ch = new CompanyHistoric();
		
		mapper.map(company, ch);
		ch.setId(null);
		ch.setVersion(null);
		ch.setFechaCreacion(new Date());
		ch.save();
		
	}


}
