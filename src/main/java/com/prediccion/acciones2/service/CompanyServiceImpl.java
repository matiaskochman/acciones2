package com.prediccion.acciones2.service;

import javax.persistence.EntityManager;

import com.prediccion.acciones2.domain.Company;


public class CompanyServiceImpl implements CompanyService {


	@Override
	public void saveOrUpdate(Company c) {
		EntityManager em =  c.getEntityManager();
		
		if(!em.contains(c)){
			c.persist();
		}else{
			c.merge();
		}
		
	}
}
