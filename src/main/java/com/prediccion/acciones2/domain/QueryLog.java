package com.prediccion.acciones2.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class QueryLog {

	
	
    public QueryLog() {
		super();
		this.forecastFail = 0;
		// TODO Auto-generated constructor stub
	}

	@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaQuery;

    /**
     */
    private String market;

    /**
     */
    private String forecastOk;

    /**
     */
    private Integer forecastFail;
    //@Column(length=200000)
    private String data;
    
    public synchronized void setForecastFail(Integer forecastFail) {
        this.forecastFail = forecastFail;
    }
    
}
