package com.prediccion.acciones2.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.prediccion.acciones2.domain.Company;

@ContextConfiguration(locations = { "/META-INF/spring/applicationContext.xml" })
public class CompanyServiceTest extends AbstractJUnit4SpringContextTests{
	
    @Autowired
    CompanyService companyService;

    @Test
    public void test(){
    	List<Company> lista = companyService.findAllCompanys();
    	
    	lista.size();
    }
    
}
