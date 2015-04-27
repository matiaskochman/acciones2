package com.prediccion.acciones2.service;

import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.prediccion.acciones2.domain.Company;
import com.prediccion.acciones2.service.CompanyService;
import com.prediccion.acciones2.service.ParsingService;

@ContextConfiguration(locations = { "/META-INF/spring/applicationContext.xml" })
public class ParsingServiceTest extends AbstractJUnit4SpringContextTests{
	
    @Autowired
    ParsingService parsingService;

    @Autowired
    CompanyService companyService;
    
    @Test
    public void test(){

    	Set<Company> list = parsingService.getSocksFromGoogleFinance(parsingService.buildQueryForParis(null));
    	Set<Company> list2 = parsingService.getSocksFromGoogleFinance(parsingService.buildQueryForUS(null));
    	Set<Company> list3 = parsingService.getSocksFromGoogleFinance(parsingService.buildQueryForLondon(null));

    	list.addAll(list2);
    	list.addAll(list3);
    	
    	
    	Integer count =0 ;
    	for (Company company : list) {
    		//company.merge();
			System.out.println(++count +" "+company);
		}
    	
    }
    
}
