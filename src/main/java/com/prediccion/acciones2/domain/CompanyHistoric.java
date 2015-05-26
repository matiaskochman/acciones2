package com.prediccion.acciones2.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class CompanyHistoric {

    @PersistenceContext
    transient EntityManager entityManager;
	
	
    @Column
    private String title;
    @Column
    private String ticker;
    @Column
    private String market;
    @Column
    private Double stockValue;
    @Column
    private Double maxForecastPercentageValue;
    @Column
    private Double medForecastPercentageValue;
    @Column
    private Double minForecastPercentageValue;
    @Column
    private Double maxForecastValue;
    @Column
    private Double medForecastValue;
    @Column
    private Double minForecastValue;
    @Column
    private Double price52WeekPercChange;
    @Column
    private Double recomendacionAverage;
    @Column
    private Integer recomendacionBuy;
    @Column
    private Integer recomendacionOutPerform;
    @Column
    private Integer recomendacionHold;
    @Column
    private Integer recomendacionUnderPerform;
    @Column
    private Integer recomendacionSell;
    @Column
    private Integer recomendacionNoOpinion;
    @Column
    private String volumenNegociado;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaCreacion;
    @Column
    private Double marketCap;
    @Column
    private Double pe;
    @Column
    private String exchange;
    @Column
    private String companyId;
    @Column
    private String localCurrencySymbol;
    @Column
    private Double recomendacionAverage_last_year;
    @Column
    private Integer recomendacionBuy_last_year;
    @Column
    private Integer recomendacionOutPerform_last_year;
    @Column
    private Integer recomendacionHold_last_year;
    @Column
    private Integer recomendacionUnderPerform_last_year;
    @Column
    private Integer recomendacionSell_last_year;
    
    public void save() {
        if (entityManager.contains(this)) {
        	entityManager.merge(this);
        } else {
        	entityManager.persist(this);
        }
        //entityManager.flush();
    }    
}
