package com.prediccion.acciones2.service;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import com.prediccion.acciones2.domain.Company;

@ContextConfiguration(locations = { "/META-INF/spring/applicationContext.xml" })
public class ParsingServiceTest extends AbstractJUnit4SpringContextTests{
	
    @Autowired
    ParsingService parsingService;

    @Autowired
    CompanyService companyService;

    @Autowired
    CompanyHistoricService companyHistoricService;
    
    @Test
    public void test(){

    	Set<Company> list = parsingService.getSocksFromGoogleFinance(parsingService.buildQueryForUS("500"));
    	//Set<Company> list2 = parsingService.getSocksFromGoogleFinance(parsingService.buildQueryForParis("4"));
    	//Set<Company> list3 = parsingService.getSocksFromGoogleFinance(parsingService.buildQueryForLondon("5"));//1300

    	//list.addAll(list2);
    	//list.addAll(list3);
    	
    	
    	Integer count =0 ;
    	
    	List<Company> listCompanies = companyService.findAllCompanys();
    	
    	companyHistoricService.createHistotic(listCompanies);
    	
    	for (Company company : list) {
    		companyService.saveOrUpdate(company);
			System.out.println(++count +" "+company);
		}
    	
    }
    
}
