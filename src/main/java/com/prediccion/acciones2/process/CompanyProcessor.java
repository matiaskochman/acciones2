package com.prediccion.acciones2.process;

import org.springframework.beans.factory.annotation.Autowired;

import com.prediccion.acciones2.domain.Company;
import com.prediccion.acciones2.service.CompanyService;

public class CompanyProcessor implements Runnable{

	@Autowired
	CompanyService companyService;
	
	private Company company;
	
	
	
	public CompanyProcessor(Company company){
		this.company = company;
	}
	
	@Override
	public void run() {
		companyService.saveOrUpdate(company);
	}

}
