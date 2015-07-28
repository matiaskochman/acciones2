package com.prediccion.acciones2.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.prediccion.acciones2.domain.Company;

@ContextConfiguration(locations = { "/META-INF/spring/applicationContext.xml" })
public class ParsingServiceTest extends AbstractJUnit4SpringContextTests{
	
    @Autowired
    ParsingService parsingService;

    @Autowired
    CompanyService companyService;

    @Autowired
    CompanyHistoricService companyHistoricService;
    
    @Autowired
    StoringServiceImpl storingService;
    
    //BlockingQueue<Company> queue = new ArrayBlockingQueue<Company>(10000);
    
    Thread t;
    
    @Test
    public void test(){


		storingService.proceed();
		

    }
    

}
