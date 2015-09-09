package com.prediccion.acciones2.domain;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Index;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJson
@RooJpaActiveRecord(finders = { "findCompanysByCompanyIdEquals" })
@Table(name = "company",
indexes = {@Index(name = "company_id_idx",  columnList="company_id", unique = true)})
public class Company {

    public Company(EntityManager entityManager, String title, String ticker, String market, Double stockValue, Double maxForecastPercentageValue, Double medForecastPercentageValue, Double minForecastPercentageValue, Double maxForecastValue, Double medForecastValue, Double minForecastValue, Double price52WeekPercChange, Double recomendacionAverage, Integer recomendacionBuy, Integer recomendacionOutPerform, Integer recomendacionHold, Integer recomendacionUnderPerform, Integer recomendacionSell, Integer recomendacionNoOpinion, String volumenNegociado, Date fechaCreacion, String marketCap, Double pe, String exchange, String companyId, String localCurrencySymbol, Double recomendacionAverage_last_year, Integer recomendacionBuy_last_year, Integer recomendacionOutPerform_last_year, Integer recomendacionHold_last_year, Integer recomendacionUnderPerform_last_year, Integer recomendacionSell_last_year, Double recomendacionAverage_last_3months, Integer recomendacionBuy_last_3months, Integer recomendacionOutPerform_last_3months, Integer recomendacionHold_last_3months, Integer recomendacionUnderPerform_last_3months, Integer recomendacionSell_last_3months, Double recomendacionAverage_last_2months, Integer recomendacionBuy_last_2months, Integer recomendacionOutPerform_last_2months, Integer recomendacionHold_last_2months, Integer recomendacionUnderPerform_last_2months, Integer recomendacionSell_last_2months, Double recomendacionAverage_last_4weeks, Integer recomendacionBuy_last_4weeks, Integer recomendacionOutPerform_last_4weeks, Integer recomendacionHold_last_4weeks, Integer recomendacionUnderPerform_last_4weeks, Integer recomendacionSell_last_4weeks) {
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
        this.fechaCreacion = new Date();
		this.fechaModificacion = this.fechaCreacion;
        setMarket(exchange);
    }

    
    public Company() {
		super();
		this.fechaCreacion = new Date();
		
		// TODO Auto-generated constructor stub
	}


	@PersistenceContext
    transient EntityManager entityManager;

    @Column
    private String title;

    @NotNull
    private String ticker;

    @NotNull
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
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Column
    private Date fechaModificacion;
    
    @Column
    private String marketCap;

    @Column
    private Double pe;

    @NotNull
    private String exchange;

    @Column(name = "company_id", nullable = false, unique=true)    
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

    public void setMarket(String exchange) {
        if (exchange.equalsIgnoreCase("NYSE")) {
            this.market = ":NYQ";
        } else if (exchange.equalsIgnoreCase("NASDAQ")) {
            this.market = ":NSQ";
        } else if (exchange.equalsIgnoreCase("LON")) {
            this.market = ":LSE";
        } else if (exchange.equalsIgnoreCase("EPA")) {
            this.market = ":PAR";
        } else if (exchange.equalsIgnoreCase("OTCQB")) {
            this.market = ":QBB";
        } else if (exchange.equalsIgnoreCase("CVE")) {
            this.market = ":CVE";
        } else if (exchange.equalsIgnoreCase("TSE")) {
            this.market = ":TOR";
        } else if (exchange.equalsIgnoreCase("FRA")) {
            this.market = ":FRA";
        } else if (exchange.equalsIgnoreCase("ETR")) {
            this.market = "X:GER";
        } else if (exchange.equalsIgnoreCase("BIT")) {
            this.market = ":MIL";
        } else if (exchange.equalsIgnoreCase("BME")) {
            this.market = ":MCE";
        } else if (exchange.equalsIgnoreCase("BVMF")) {
            this.market = ":SAO";
        } else if (exchange.equalsIgnoreCase("EBR")) {
            this.market = ":BRU";
        } else if (exchange.equalsIgnoreCase("AMS")) {
            this.market = ":AEX";
        } else if (exchange.equalsIgnoreCase("ASX")) {
            this.market = ":ASX";
        } else if (exchange.equalsIgnoreCase("NZE")) {
            this.market = ":NZC";
        } else if (exchange.equalsIgnoreCase("TPE")) {
            this.market = ":TAI";
        } else if (exchange.equalsIgnoreCase("SGX")) {
            this.market = ":SES";
        } else if (exchange.equalsIgnoreCase("TYO")) {
            this.market = ":TYO";
        } else if (exchange.equalsIgnoreCase("SHA")) {
            this.market = ":SHH";
        } else if (exchange.equalsIgnoreCase("SHE")) {
            this.market = ":SHH";
        } else if (exchange.equalsIgnoreCase("VTX")) {
            this.market = ":VTX";
        } else if (exchange.equalsIgnoreCase("SWX")) {
            this.market = ":SWX";
        } else if (exchange.equalsIgnoreCase("WSE")) {
            this.market = ":WSE";
        } else if (exchange.equalsIgnoreCase("IST")) {
            this.market = ":IST";
        } else if (exchange.equalsIgnoreCase("STO")) {
            this.market = ":STO";
        } else if (exchange.equalsIgnoreCase("JSE")) {
            this.market = ":JNB";
        } else if (exchange.equalsIgnoreCase("MCX")) {
            this.market = ":MCX";
        }
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((companyId == null) ? 0 : companyId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		return true;
	}


	public void setFechaCreacion(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.clear(Calendar.SECOND);
        c.clear(Calendar.MILLISECOND);
        c.clear(Calendar.MINUTE);
        c.clear(Calendar.HOUR);
        c.clear(Calendar.HOUR_OF_DAY);
        this.fechaCreacion = c.getTime();
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
        setMarket(exchange);
        setMercado();
    }

    public void generateOpinionAverage() {
        if (recomendacionBuy != null || recomendacionUnderPerform != null || recomendacionOutPerform != null || recomendacionSell != null) {
            this.recomendacionAverage = recomendacionOutPerform.doubleValue() + recomendacionBuy.doubleValue() * 1.5D - recomendacionUnderPerform.doubleValue() - recomendacionSell.doubleValue() * 1.5D;
        }
    }

    public void generateOpinionAverage_last_year() {
        if (recomendacionBuy_last_year != null || recomendacionUnderPerform_last_year != null || recomendacionOutPerform_last_year != null || recomendacionSell_last_year != null) {
            this.recomendacionAverage_last_year = recomendacionOutPerform_last_year.doubleValue() + recomendacionBuy_last_year.doubleValue() * 1.5D - recomendacionUnderPerform_last_year.doubleValue() - recomendacionSell_last_year.doubleValue() * 1.5D;
        }
    }

    public void generateOpinionAverage_last_3months() {
        if (recomendacionBuy_last_3months != null || recomendacionUnderPerform_last_3months != null || recomendacionOutPerform_last_3months != null || recomendacionSell_last_3months != null) {
            this.recomendacionAverage_last_3months = recomendacionOutPerform_last_3months.doubleValue() + recomendacionBuy_last_3months.doubleValue() * 1.5D - recomendacionUnderPerform_last_3months.doubleValue() - recomendacionSell_last_3months.doubleValue() * 1.5D;
        }
    }

    public void generateOpinionAverage_last_2months() {
        if (recomendacionBuy_last_2months != null || recomendacionUnderPerform_last_2months != null || recomendacionOutPerform_last_2months != null || recomendacionSell_last_2months != null) {
            this.recomendacionAverage_last_2months = recomendacionOutPerform_last_2months.doubleValue() + recomendacionBuy_last_2months.doubleValue() * 1.5D - recomendacionUnderPerform_last_2months.doubleValue() - recomendacionSell_last_2months.doubleValue() * 1.5D;
        }
    }

    public void generateOpinionAverage_last_4weeks() {
        if (recomendacionBuy_last_4weeks != null || recomendacionUnderPerform_last_4weeks != null || recomendacionOutPerform_last_4weeks != null || recomendacionSell_last_4weeks != null) {
            this.recomendacionAverage_last_4weeks = recomendacionOutPerform_last_4weeks.doubleValue() + recomendacionBuy_last_4weeks.doubleValue() * 1.5D - recomendacionUnderPerform_last_4weeks.doubleValue() - recomendacionSell_last_4weeks.doubleValue() * 1.5D;
        }
    }

    public Integer getRecomendacionBuy() {
        return this.recomendacionBuy;
    }

    public void setRecomendacionBuy(Integer recomendacionBuy) {
        this.recomendacionBuy = recomendacionBuy;
    }

    public Integer getRecomendacionOutPerform() {
        return this.recomendacionOutPerform;
    }

    public void setRecomendacionOutPerform(Integer recomendacionOutPerform) {
        this.recomendacionOutPerform = recomendacionOutPerform;
    }

    public Integer getRecomendacionUnderPerform() {
        return this.recomendacionUnderPerform;
    }

    public void setRecomendacionUnderPerform(Integer recomendacionUnderPerform) {
        this.recomendacionUnderPerform = recomendacionUnderPerform;
    }

    public Integer getRecomendacionSell() {
        return this.recomendacionSell;
    }

    public void setRecomendacionSell(Integer recomendacionSell) {
        this.recomendacionSell = recomendacionSell;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public String toString() {
        DateTime dt = new DateTime(this.getFechaCreacion());

        String dateFormatted = dt.toString("dd:mm:yyyy");
        return "ticker=" + ticker + ", market=" + this.city + ", stockValue=" + stockValue + ", maxPVal=" + maxForecastPercentageValue + "%" + ", medPVal=" + medForecastPercentageValue + "%" + ", minPVal=" + minForecastPercentageValue + "%" + ", Average=" + recomendacionAverage + ", Average_last_Y=" + recomendacionAverage_last_year + ", p52W=" + price52WeekPercChange + ", Buy=" + recomendacionBuy + ", OutPerform=" + recomendacionOutPerform + ", Hold=" + recomendacionHold + ", UnderPerform=" + recomendacionUnderPerform + ", Sell_last_Y=" + recomendacionSell_last_year + ", Buy_last_Y=" + recomendacionBuy_last_year + ", OutPerform_last_Y=" + recomendacionOutPerform_last_year + ", Hold_last_Y=" + recomendacionHold_last_year + ", UnderPerform_last_Y=" + recomendacionUnderPerform_last_year + ", Sell_last_Y=" + recomendacionSell_last_year + ", volNegociado=" + volumenNegociado + ", fechaCreacion=" + dateFormatted;
    }

    public static List<Company> findAllCompanys() {
        return entityManager().createQuery("SELECT o FROM Company o", Company.class).getResultList();
    }

    public String setMercado() {
        if (exchange.equalsIgnoreCase("NYSE")) {
        	this.city = exchange;
        } else if (exchange.equalsIgnoreCase("NASDAQ")) {
        	this.city = exchange;        	
        } else if (exchange.equalsIgnoreCase("LON")) {
        	this.city = "LONDON";
        } else if (exchange.equalsIgnoreCase("EPA")) {
            this.city =  "PARIS";
        } else if (exchange.equalsIgnoreCase("OTCQB")) {
            this.city =  "NEW YORK, " + exchange;
        } else if (exchange.equalsIgnoreCase("CVE")) {
            this.city =  "TORONTO";
        } else if (exchange.equalsIgnoreCase("TSE")) {
            this.city =  "TORONTO";
        } else if (exchange.equalsIgnoreCase("FRA")) {
            this.city =  "FRANKFURT";
        } else if (exchange.equalsIgnoreCase("ETR")) {
            this.city =  "GERMANY";
        } else if (exchange.equalsIgnoreCase("BIT")) {
            this.city =  "MILAN";
        } else if (exchange.equalsIgnoreCase("BME")) {
            this.city =  "MADRID";
        } else if (exchange.equalsIgnoreCase("BVMF")) {
            this.city =  "SAO PAULO";
        } else if (exchange.equalsIgnoreCase("EBR")) {
            this.city =  "BRUSSELS";
        } else if (exchange.equalsIgnoreCase("AMS")) {
            this.city =  "AMSTERDAM";
        } else if (exchange.equalsIgnoreCase("ASX")) {
            this.city =  "AUSTRALIA";
        } else if (exchange.equalsIgnoreCase("NZE")) {
            this.city =  "NEW ZELAND";
        } else if (exchange.equalsIgnoreCase("TPE")) {
            this.city =  "TAIWAN";
        } else if (exchange.equalsIgnoreCase("SGX")) {
            this.city =  "SINGAPORE";
        } else if (exchange.equalsIgnoreCase("TYO")) {
            this.city =  "TOKYO";
        } else if (exchange.equalsIgnoreCase("SHA")) {
            this.city =  "SHANGAI";
        } else if (exchange.equalsIgnoreCase("SHE")) {
            this.city =  "SHANGAI";
        } else if (exchange.equalsIgnoreCase("VTX")) {
            this.city =  "SWISS";
        } else if (exchange.equalsIgnoreCase("SWX")) {
            this.city =  "SWISS";
        } else if (exchange.equalsIgnoreCase("WSE")) {
            this.city =  "WARSAW";
        } else if (exchange.equalsIgnoreCase("IST")) {
            this.city =  "ISTAMBUL";
        } else if (exchange.equalsIgnoreCase("STO")) {
            this.city =  "STOCKOLM";
        } else if (exchange.equalsIgnoreCase("JSE")) {
            this.city =  "JOHANESBOURG";
        } else if (exchange.equalsIgnoreCase("MCX")) {
            this.city =  "MOSCOW";
        }else{
        	
        	this.city =  "UNKWONW";
        }
        
        return city;
    }
}
