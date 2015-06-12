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
		Set<Company> list21 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForSouthAfrica("350"),1); //237
		 */
		
		//Set<Company> list1 =null; 
		
		Set<Company> list1 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "8000000000", "8400000000"),180);//21000
		//list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "50000000", "100000000"),180));//21000
		//list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "100000000", "200000000"),180));//21000
		//list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "200000000", "300000000"),180));//21000
		//list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "300000000", "400000000"),180));//21000
		//list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "400000000", "500000000"),180));//21000
		//list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "500000000", "700000000"),180));//21000
		//list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "900000000", "1200000000"),180));//21000
		//list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "1200000000", "1500000000"),180));//21000
		//list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "1500000000", "1700000000"),180));//21000
		//list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "1700000000", "2000000000"),180));//21000
		//list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "2000000000", "2300000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "2300000000", "2500000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "2500000000", "2800000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "2800000000", "3100000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "3100000000", "3400000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "3400000000", "3700000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "3700000000", "4000000000"),180));//21000
		
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "4000000000", "4400000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "4400000000", "4800000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "4800000000", "5200000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "5200000000", "5600000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "5600000000", "6000000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "6000000000", "6400000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "6400000000", "6800000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "6800000000", "7200000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "7200000000", "7600000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "7600000000", "8000000000"),180));//21000
		list1.addAll(parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("1000", "8000000000", "8400000000"),180));//21000

		
		/*
		Set<Company> list5 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForGermany("1600"),90); //1600
		Set<Company> list4 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForCanada("4000"),90);//4000
    	Set<Company> list2 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForParis("1500"),90);//1500
    	Set<Company> list3 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForLondon("1300"),90);//1300
    	Set<Company> list6 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForItaly("350"),90); //350
    	Set<Company> list7 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForSpain("140"),90); //140
    	Set<Company> list8 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForBrasil("1000"),90); //1000
    	Set<Company> list9 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForBelgium("140"),90); //159
    	Set<Company> list10 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForNetherlands("120"),90); //126
    	Set<Company> list11 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForAustralia("1700"),90); //1964
    	Set<Company> list12 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForNewZeland("140"),90); //152
    	Set<Company> list13 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForTaiwan("890"),90); //897
    	Set<Company> list14 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForSingapore("700"),90); //759
    	Set<Company> list15 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForJapan("3000"),90); //3656
    	Set<Company> list16 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForChina("2500"),90); //2830
    	Set<Company> list17 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForSwitzerland("230"),90); //237
    	Set<Company> list18 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForPoland("400"),90); //237
    	Set<Company> list19 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForTurkey("390"),90); //237
    	Set<Company> list20 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForSweden("290"),90); //237
    	Set<Company> list22 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForRussia("275"),90); //237
		 */

		resultSet.addAll(list1);
    	/*
    	resultSet.addAll(list2);
    	resultSet.addAll(list3);
		resultSet.addAll(list4);
		resultSet.addAll(list5);
    	resultSet.addAll(list6);
    	resultSet.addAll(list7);
    	resultSet.addAll(list8);
    	resultSet.addAll(list9);
    	resultSet.addAll(list10);
    	resultSet.addAll(list11);
    	resultSet.addAll(list12);
    	resultSet.addAll(list13);
    	resultSet.addAll(list14);
    	resultSet.addAll(list15);
    	resultSet.addAll(list16);
    	resultSet.addAll(list17);
    	resultSet.addAll(list18);
    	resultSet.addAll(list19);
    	resultSet.addAll(list20);
    	resultSet.addAll(list22);
    	 */
    	
    	
    	/*
		resultSet.addAll(list21);
    	 */
    	Integer count =0 ;
    	
    	List<Company> listCompanies = companyService.findAllCompanys();
    	
    	companyHistoricService.createHistotic(listCompanies);
    	
    	for (Company company : resultSet) {
			 if(CompanyFilter.percentageForecastIntegrityValid(company)&&CompanyFilter.percentageForecastNotEquals(company)){
				 System.out.println(++count +" "+company);
				 companyService.saveOrUpdate(company);
			 }
		}
    }
}
