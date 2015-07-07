package com.prediccion.acciones2.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.prediccion.acciones2.domain.Company;
import com.prediccion.acciones2.utils.QueryBuilder;

@ContextConfiguration(locations = { "/META-INF/spring/applicationContext.xml" })
public class ParsingServiceTest extends AbstractJUnit4SpringContextTests{
	
    @Autowired
    ParsingService parsingService;

    @Autowired
    CompanyService companyService;

    @Autowired
    CompanyHistoricService companyHistoricService;
    
    BlockingQueue<Company> queue = new ArrayBlockingQueue<Company>(10000);
    
    Thread t;
    
    @Test
    public void test(){

    	/*
		Comparator<Company> minComparator = new Comparator<Company>(){
			@Override
			public int compare(Company o1, Company o2) {
				int min = o1.getMinForecastPercentageValue().compareTo(o2.getMinForecastPercentageValue());
				return min*(-1);
			}
		};		    
    	
		TreeSet<Company> resultSet = new TreeSet<Company>(minComparator);
		*/
    	Set<Company> resultSet = new HashSet<Company>();
		Set<Company> set = Collections.synchronizedSet(resultSet);
		
		/*
		Set<Company> list21 = parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForSouthAfrica("350"),1); //237
		
		Set<Company> list1 =null; 
		 */
		
		/*
		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "10000000", "500000000"),100,set);//21000
		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "500000000", "1000000000"),100,set);//21000
		
		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "1000000000", "2000000000"),100,set);//21000
		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "2000000000", "5000000000"),100,set);//21000
		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "5000000000", "10000000000"),100,set);//21000
		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "10000000000", "15000000000"),100,set);//21000
		
		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "15000000000", "90000000000"),100,set);//21000
		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "90000000000", "2000000000000"),100,set);//21000
		 */
		
        Thread t1 = new Thread(new Runnable() {
            public void run() {
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForJapan("4000"),100,queue); //3656
            	
            	Company poison = new Company();
            	poison.setCity("Lanus");
            	queue.add(poison);
            }
        });		

		this.t = t1;
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });        
        
        try {
        	t1.start();
        	t2.start();
        	
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
		/*
        parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForBelgium("1500"),100,queue); //159
        parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForLondon("6000",null,null),100,queue);
		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForCanada("6000"),100,set);//6000
    	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForParis("2500"),100,set);//1500
        parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForGermany("6000"),100,queue); //1600
    	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForItaly("2000"),100,set); //350
    	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForSpain("2000"),100,set); //160
    	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForBrasil("1800"),100,set); //1000
    	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForNetherlands("1500"),100,set); //126
    	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForAustralia("6000"),100,set); //1964
    	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForNewZeland("160"),60,set); //152
    	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForTaiwan("2500"),60,set); //897
    	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForSingapore("700"),60,set); //759
    	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForChina("3500"),100,set); //2830
    	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForSwitzerland("400"),60,set); //237
    	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForPoland("400"),60,set); //237
    	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForTurkey("500"),60,set); //237
    	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForSweden("400"),60,set); //237
    	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForRussia("350"),60,set); //237
    	
		 */
    	Integer count =0 ;
    	//List<Company> listCompanies = companyService.findAllCompanys();
    	
    	//companyHistoricService.createHistotic(listCompanies);
    	
    	/*
    	for (Company company : set) {
    		System.out.println(++count +" "+company);
    		companyService.saveOrUpdate(company);
    		
		}
		*/
    }
    
    private void consumer() throws InterruptedException {
    	Integer count =0 ;
        
        while(true) {
            //Thread.sleep(5);
            
            Company company = queue.take();
            
            if(company.getCity()!=null && company.getCity().equalsIgnoreCase("LANUS")){
            	break;
            }
            
    		System.out.println(++count +" "+company);
    		companyService.saveOrUpdate(company);
            
        }
    }    
}
