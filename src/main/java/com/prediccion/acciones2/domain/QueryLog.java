package com.prediccion.acciones2.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.json.RooJson;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

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
}
