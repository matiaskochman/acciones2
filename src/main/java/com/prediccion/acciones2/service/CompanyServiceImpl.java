package com.prediccion.acciones2.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.dao.EmptyResultDataAccessException;

import com.googlecode.ehcache.annotations.Cacheable;
import com.prediccion.acciones2.domain.Company;


public class CompanyServiceImpl implements CompanyService {

	private Mapper mapper = new DozerBeanMapper();
	
	
	@Cacheable(cacheName="companies")
    public List<Company> findAllCompanys() {
        return Company.findAllCompanys();
    }
    

	@Override
	public void saveOrUpdate(Company c) {
		EntityManager em =  c.getEntityManager();
		Company comp = null;
		
		try{
			
			comp = Company.findCompanysByCompanyIdEquals(c.getCompanyId()).getSingleResult();
			c.setId(comp.getId());
			mapper.map(c, comp);
			comp.setVersion(comp.getVersion());
			comp.setFechaModificacion(new Date());
			comp.merge();
		}catch( EmptyResultDataAccessException e){
			c.persist();
		}
		
	}
}
