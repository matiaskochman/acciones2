package com.prediccion.acciones2.service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.prediccion.acciones2.domain.Company;
import com.prediccion.acciones2.filter.CompanyFilter;
import com.prediccion.acciones2.utils.QueryBuilder;

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

		/*
		Set<Company> list1 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("4000"));//2000
		Set<Company> list5 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForGermany("1600")); //1600
		Set<Company> list4 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForCanada("4000"));//4000
    	Set<Company> list2 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForParis("1500"));//1500
    	Set<Company> list3 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForLondon("1300"));//1300
    	Set<Company> list6 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForItaly("350")); //350
    	Set<Company> list7 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForSpain("140")); //140
    	Set<Company> list8 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForBrasil("1000")); //1000
    	Set<Company> list9 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForBelgium("140")); //140
    	Set<Company> list10 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForNetherlands("120")); //140
		 */
    	Set<Company> list11 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForAustralia("1000")); //1400

		/*
		resultSet.addAll(list1);
		resultSet.addAll(list4);
		resultSet.addAll(list5);
    	resultSet.addAll(list2);
    	resultSet.addAll(list3);
    	resultSet.addAll(list6);
    	resultSet.addAll(list7);
    	resultSet.addAll(list8);
    	resultSet.addAll(list9);
    	resultSet.addAll(list10);
		 */
    	resultSet.addAll(list11);
    	
    	
    	Integer count =0 ;
    	
    	List<Company> listCompanies = companyService.findAllCompanys();
    	
    	companyHistoricService.createHistotic(listCompanies);
    	
    	
    	for (Company company : resultSet) {
    		
			 if(CompanyFilter.percentageForecastIntegrityValid(company)&&CompanyFilter.percentageForecastNotEquals(company)){
				 companyService.saveOrUpdate(company);
				 System.out.println(++count +" "+company);
			 }
    		
		}
    	
    }
    
}
