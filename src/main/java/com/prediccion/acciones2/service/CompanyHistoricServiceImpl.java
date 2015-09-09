package com.prediccion.acciones2.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.dao.EmptyResultDataAccessException;
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
	@Transactional
	public void createHistoricForCompany(Company company) {
		CompanyHistoric ch = new CompanyHistoric();
		
		Calendar startdate = Calendar.getInstance();
		startdate.clear(Calendar.MILLISECOND);
		startdate.clear(Calendar.SECOND);
		startdate.clear(Calendar.MINUTE);
		startdate.clear(Calendar.HOUR);
		startdate.clear(Calendar.HOUR_OF_DAY);
		
		Calendar enddate = Calendar.getInstance();
		enddate.add(Calendar.MILLISECOND, 999);
		enddate.add(Calendar.SECOND,59);
		enddate.add(Calendar.MINUTE,59);
		//enddate.add(Calendar.HOUR,53);
		enddate.add(Calendar.HOUR_OF_DAY,23);

		try{
			
			ch = CompanyHistoric.findCompanyHistoricsByCompanyIdEqualsAndFechaCreacionEquals(company.getCompanyId(),startdate.getTime(), enddate.getTime());
			Integer version = ch.getVersion();
			Long id = ch.getId();
			
			mapper.map(company, ch);
			ch.setId(id);
			ch.setVersion(version);
			ch.setFechaCreacion(enddate.getTime());
			ch.merge();
		}catch( EmptyResultDataAccessException e){
			try{
				mapper.map(company, ch);
				ch.setId(null);
				ch.setVersion(null);
				ch.setFechaCreacion(enddate.getTime());
				ch.persist();
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}catch(Exception exep){
			exep.printStackTrace();
		}
		
		
	}


}
