package com.prediccion.acciones2.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.prediccion.acciones2.domain.Company;


public class CompanyServiceImpl implements CompanyService {

    public List<Company> findAllCompanys() {
        return Company.findAllCompanys();
    }
    

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
