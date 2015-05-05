package com.prediccion.acciones2.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = { "/META-INF/spring/applicationContext.xml" })
public class CompanyServiceTest {
	
    @Autowired
    CompanyService companyService;

    @Test
    public void test(){
    	List lista = companyService.findAllCompanys();
    	
    	lista.size();
    }
    
}
