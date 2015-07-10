package com.prediccion.acciones2.service;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prediccion.acciones2.domain.Company;
import com.prediccion.acciones2.utils.QueryBuilder;

@Service
public class StoringServiceImpl {

    @Autowired
    CompanyService companyService;

    @Autowired
    ParsingService parsingService;
    
    BlockingQueue<Company> queue = new ArrayBlockingQueue<Company>(100000);
    
    volatile boolean timerOn = true;
    
	//ExecutorService executorService = Executors.newFixedThreadPool(1);
    
    
    public void proceed(){
        Thread t1 = new Thread(new Runnable() {
            public void run() {
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForBelgium("1500"),60,queue); //159
            	/*
            	 */
        		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "10000000", "500000000"),60,queue);//21000
        		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "500000000", "1000000000"),60,queue);//21000
        		
        		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "1000000000", "2000000000"),60,queue);//21000
        		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "2000000000", "5000000000"),60,queue);//21000
        		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "5000000000", "10000000000"),60,queue);//21000
        		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "10000000000", "15000000000"),60,queue);//21000
        		
        		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "15000000000", "90000000000"),60,queue);//21000
        		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForUS("5000", "90000000000", "2000000000000"),60,queue);//21000
            	
                parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForLondon("6000",null,null),60,queue);
        		parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForCanada("6000"),60,queue);//6000
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForParis("2500"),60,queue);//1500
                parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForGermany("6000"),60,queue); //1600
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForItaly("2000"),60,queue); //350
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForSpain("2000"),60,queue); //160
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForBrasil("1800"),60,queue); //1000
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForNetherlands("1500"),60,queue); //126
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForAustralia("6000"),60,queue); //1964
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForNewZeland("160"),60,queue); //152
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForTaiwan("2500"),60,queue); //897
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForSingapore("700"),60,queue); //759
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForChina("3500"),60,queue); //2830
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForSwitzerland("400"),60,queue); //237
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForPoland("400"),60,queue); //237
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForTurkey("500"),60,queue); //237
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForSweden("400"),60,queue); //237
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForRussia("350"),60,queue); //237      
            	
            	
            	parsingService.getSocksFromGoogleFinance(QueryBuilder.buildQueryForJapan("4000"),60,queue); //3656
            	Company poison = new Company();
            	poison.setCity("Lanus");
            	queue.add(poison);
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
        	public void run() {
        		consumer();
        	}
        });
        
        t2.start();
        t1.start();
        try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
	
    private void consumer() {
    	Integer count =0 ;
        Integer seconds = 60;
    	Integer minutes = seconds * 120;
        Timer timer = new Timer();
        
        TimerTask tt = new TimerTask() {
			
			@Override
			public void run() {
				timerOn = false;
				System.out.println("timer off");
			}
		};
        
        timer.schedule(tt,minutes * seconds * 1000);    	
    	
        while(timerOn) {
            
            Company company;
			try {
				company = queue.take();
				if(company.getCity()!=null && company.getCity().equalsIgnoreCase("LANUS")){
					break;
				}
				
				System.out.println(++count +" "+company);

				//executorService.submit(new CompanyProcessor(company));
				
	    		companyService.saveOrUpdate(company);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            

            
        }
    }     

}
