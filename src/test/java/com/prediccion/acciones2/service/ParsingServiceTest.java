package com.prediccion.acciones2.service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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

		Comparator<Company> minComparator = new Comparator<Company>(){
			@Override
			public int compare(Company o1, Company o2) {
				int min = o1.getMinForecastPercentageValue().compareTo(o2.getMinForecastPercentageValue());
				return min*(-1);
			}
		};		    
    	
		TreeSet<Company> resultSet = new TreeSet<Company>(minComparator);

    	//Set<Company> list1 = parsingService.getSocksFromGoogleFinance(parsingService.buildQueryForUS("20"));
    	
    	//Set<Company> list2 = parsingService.getSocksFromGoogleFinance(parsingService.buildQueryForParis("4"));
    	//Set<Company> list3 = parsingService.getSocksFromGoogleFinance(parsingService.buildQueryForLondon("5"));//1300
    	//Set<Company> list4 = parsingService.getSocksFromGoogleFinance(parsingService.buildQueryForCanada(null));
    	Set<Company> list5 = parsingService.getSocksFromGoogleFinance(parsingService.buildQueryForGermany("1500")); //1500
    	Set<Company> list6 = parsingService.getSocksFromGoogleFinance(parsingService.buildQueryForItaly("350")); //350

    	//resultSet.addAll(list1);
    	//resultSet.addAll(list2);
    	//resultSet.addAll(list3);
    	resultSet.addAll(list5);
    	resultSet.addAll(list6);
    	
    	
    	Integer count =0 ;
    	
    	List<Company> listCompanies = companyService.findAllCompanys();
    	
    	companyHistoricService.createHistotic(listCompanies);
    	
    	for (Company company : resultSet) {
    		companyService.saveOrUpdate(company);
			System.out.println(++count +" "+company);
		}
    	
    }
    
}
