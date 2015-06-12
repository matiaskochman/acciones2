package com.prediccion.acciones2.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
public class CompanyHistoric {
	
    @PersistenceContext
    transient EntityManager entityManager;
	

    
    public CompanyHistoric(EntityManager entityManager, String title,
			String ticker, String market, Double stockValue,
			Double maxForecastPercentageValue,
			Double medForecastPercentageValue,
			Double minForecastPercentageValue, Double maxForecastValue,
			Double medForecastValue, Double minForecastValue,
			Double price52WeekPercChange, Double recomendacionAverage,
			Integer recomendacionBuy, Integer recomendacionOutPerform,
			Integer recomendacionHold, Integer recomendacionUnderPerform,
			Integer recomendacionSell, Integer recomendacionNoOpinion,
			String volumenNegociado, Date fechaCreacion, Double marketCap,
			Double pe, String exchange, String companyId,
			String localCurrencySymbol, Double recomendacionAverage_last_year,
			Integer recomendacionBuy_last_year,
			Integer recomendacionOutPerform_last_year,
			Integer recomendacionHold_last_year,
			Integer recomendacionUnderPerform_last_year,
			Integer recomendacionSell_last_year,
			Double recomendacionAverage_last_3months,
			Integer recomendacionBuy_last_3months,
			Integer recomendacionOutPerform_last_3months,
			Integer recomendacionHold_last_3months,
			Integer recomendacionUnderPerform_last_3months,
			Integer recomendacionSell_last_3months,
			Double recomendacionAverage_last_2months,
			Integer recomendacionBuy_last_2months,
			Integer recomendacionOutPerform_last_2months,
			Integer recomendacionHold_last_2months,
			Integer recomendacionUnderPerform_last_2months,
			Integer recomendacionSell_last_2months,
			Double recomendacionAverage_last_4weeks,
			Integer recomendacionBuy_last_4weeks,
			Integer recomendacionOutPerform_last_4weeks,
			Integer recomendacionHold_last_4weeks,
			Integer recomendacionUnderPerform_last_4weeks,
			Integer recomendacionSell_last_4weeks) {
		super();
		this.entityManager = entityManager;
		this.title = title;
		this.ticker = ticker;
		this.market = market;
		this.stockValue = stockValue;
		this.maxForecastPercentageValue = maxForecastPercentageValue;
		this.medForecastPercentageValue = medForecastPercentageValue;
		this.minForecastPercentageValue = minForecastPercentageValue;
		this.maxForecastValue = maxForecastValue;
		this.medForecastValue = medForecastValue;
		this.minForecastValue = minForecastValue;
		this.price52WeekPercChange = price52WeekPercChange;
		this.recomendacionAverage = recomendacionAverage;
		this.recomendacionBuy = recomendacionBuy;
		this.recomendacionOutPerform = recomendacionOutPerform;
		this.recomendacionHold = recomendacionHold;
		this.recomendacionUnderPerform = recomendacionUnderPerform;
		this.recomendacionSell = recomendacionSell;
		this.recomendacionNoOpinion = recomendacionNoOpinion;
		this.volumenNegociado = volumenNegociado;
		this.fechaCreacion = fechaCreacion;
		this.marketCap = marketCap;
		this.pe = pe;
		this.exchange = exchange;
		this.companyId = companyId;
		this.localCurrencySymbol = localCurrencySymbol;
		this.recomendacionAverage_last_year = recomendacionAverage_last_year;
		this.recomendacionBuy_last_year = recomendacionBuy_last_year;
		this.recomendacionOutPerform_last_year = recomendacionOutPerform_last_year;
		this.recomendacionHold_last_year = recomendacionHold_last_year;
		this.recomendacionUnderPerform_last_year = recomendacionUnderPerform_last_year;
		this.recomendacionSell_last_year = recomendacionSell_last_year;
		this.recomendacionAverage_last_3months = recomendacionAverage_last_3months;
		this.recomendacionBuy_last_3months = recomendacionBuy_last_3months;
		this.recomendacionOutPerform_last_3months = recomendacionOutPerform_last_3months;
		this.recomendacionHold_last_3months = recomendacionHold_last_3months;
		this.recomendacionUnderPerform_last_3months = recomendacionUnderPerform_last_3months;
		this.recomendacionSell_last_3months = recomendacionSell_last_3months;
		this.recomendacionAverage_last_2months = recomendacionAverage_last_2months;
		this.recomendacionBuy_last_2months = recomendacionBuy_last_2months;
		this.recomendacionOutPerform_last_2months = recomendacionOutPerform_last_2months;
		this.recomendacionHold_last_2months = recomendacionHold_last_2months;
		this.recomendacionUnderPerform_last_2months = recomendacionUnderPerform_last_2months;
		this.recomendacionSell_last_2months = recomendacionSell_last_2months;
		this.recomendacionAverage_last_4weeks = recomendacionAverage_last_4weeks;
		this.recomendacionBuy_last_4weeks = recomendacionBuy_last_4weeks;
		this.recomendacionOutPerform_last_4weeks = recomendacionOutPerform_last_4weeks;
		this.recomendacionHold_last_4weeks = recomendacionHold_last_4weeks;
		this.recomendacionUnderPerform_last_4weeks = recomendacionUnderPerform_last_4weeks;
		this.recomendacionSell_last_4weeks = recomendacionSell_last_4weeks;
	}

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
    
    @Column
    private Double recomendacionAverage_last_3months;
    @Column
    private Integer recomendacionBuy_last_3months;
    @Column
    private Integer recomendacionOutPerform_last_3months;
    @Column
    private Integer recomendacionHold_last_3months;
    @Column
    private Integer recomendacionUnderPerform_last_3months;
    @Column
    private Integer recomendacionSell_last_3months;

    @Column
    private Double recomendacionAverage_last_2months;
    @Column
    private Integer recomendacionBuy_last_2months;
    @Column
    private Integer recomendacionOutPerform_last_2months;
    @Column
    private Integer recomendacionHold_last_2months;
    @Column
    private Integer recomendacionUnderPerform_last_2months;
    @Column
    private Integer recomendacionSell_last_2months;

    @Column
    private Double recomendacionAverage_last_4weeks;
    @Column
    private Integer recomendacionBuy_last_4weeks;
    @Column
    private Integer recomendacionOutPerform_last_4weeks;
    @Column
    private Integer recomendacionHold_last_4weeks;
    @Column
    private Integer recomendacionUnderPerform_last_4weeks;
    @Column
    private Integer recomendacionSell_last_4weeks;    
    @Column
    private String city;
    
    public void save() {
        if (entityManager.contains(this)) {
        	entityManager.merge(this);
        } else {
        	entityManager.persist(this);
        }
        //entityManager.flush();
    }    
}
