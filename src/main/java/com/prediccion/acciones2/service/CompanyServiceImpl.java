package com.prediccion.acciones2.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.googlecode.ehcache.annotations.Cacheable;
import com.prediccion.acciones2.domain.Company;


public class CompanyServiceImpl implements CompanyService {

	private Mapper mapper = new DozerBeanMapper();
	
	
	@Autowired
	private CompanyHistoricService companyHistoricService;
	
	@Cacheable(cacheName="companies")
    public List<Company> findAllCompanys() {
        return Company.findAllCompanys();
    }
    

	@Override
	@Transactional
	public void saveOrUpdate(Company c) {
		EntityManager em =  c.getEntityManager();
		Company comp = null;
		
		try{
			
			comp = Company.findCompanysByCompanyIdEquals(c.getCompanyId()).getSingleResult();
			Date creationDate = comp.getFechaCreacion();
			comp.setFechaModificacion(new Date());
			//comp.setVersion(comp.getVersion());
			//comp.setFechaCreacion(creationDate);
			c.setId(comp.getId());
			mapper.map(c, comp);
			comp.merge();
			comp.setId(null);
			//companyHistoricService.createHistoricForCompany(comp);
			System.out.println("company id :"+comp.getId()+" merged.");
		}catch( EmptyResultDataAccessException e){
			try{
				c.persist();
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}catch(Exception exep){
			exep.printStackTrace();
		}
		
	}
}
