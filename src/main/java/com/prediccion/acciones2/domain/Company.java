package com.prediccion.acciones2.domain;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@RooJpaActiveRecord
@RooJson
public class Company {

	public Company(String title, String ticker, String exchange,
			String companyId, String localCurrencySymbol,
			Double price52WeekPercChange,Double marketCap,Double pe,String localCurrency) {
		super();
		this.title = title;
		this.ticker = ticker;
		this.exchange = exchange;
		this.companyId = companyId;
		this.localCurrencySymbol = localCurrencySymbol;
		this.price52WeekPercChange =price52WeekPercChange;
		this.marketCap = marketCap;
		this.pe = pe;
		this.localCurrencySymbol=localCurrency;
		setMarket(exchange);
	}

    @PersistenceContext
    transient EntityManager entityManager;
	
    @NotNull
    @Column(unique = true)
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
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaCreacion;
    @Column
    private Double marketCap;
    @Column
    private Double pe;
    @NotNull
    private String exchange;
    @Column(unique = true)
    private String companyId;
    @Column
    private String localCurrencySymbol;

    public void setMarket(String exchange){
    	if(exchange.equalsIgnoreCase("NYSE")){
    		this.market = ":NYQ";
    	}else if(exchange.equalsIgnoreCase("NASDAQ")){
    		this.market = ":NSQ";
    	}else if(exchange.equalsIgnoreCase("LON")){
    		this.market = ":LSE";
    	}else if(exchange.equalsIgnoreCase("EPA")){
    		this.market = ":PAR";
    	}else if(exchange.equalsIgnoreCase("OTCQB")){
    		this.market = ":QBB";
    	}else if(exchange.equalsIgnoreCase("CVE")){
    		this.market = ":CVE";
    	}else if(exchange.equalsIgnoreCase("TSE")){
    		this.market = ":TOR";
    	}else if(exchange.equalsIgnoreCase("FRA")){
    		this.market = ":FRA";
    	}else if(exchange.equalsIgnoreCase("ETR")){
    		this.market = "X:GER";
    	}else if(exchange.equalsIgnoreCase("BIT")){
    		this.market = ":MIL";
    	}else if(exchange.equalsIgnoreCase("BME")){
    		this.market = ":MCE";
    	}else if(exchange.equalsIgnoreCase("BVMF")){
    		this.market = ":SAO";
    	}else if(exchange.equalsIgnoreCase("EBR")){
    		this.market = ":BRU";
    	}else if(exchange.equalsIgnoreCase("AMS")){
    		this.market = ":AEX";
    	}else if(exchange.equalsIgnoreCase("ASX")){
    		this.market = ":ASX";
    	}
    }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((exchange == null) ? 0 : exchange.hashCode());
		result = prime * result + ((ticker == null) ? 0 : ticker.hashCode());
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
		if (exchange == null) {
			if (other.exchange != null)
				return false;
		} else if (!exchange.equals(other.exchange))
			return false;
		if (ticker == null) {
			if (other.ticker != null)
				return false;
		} else if (!ticker.equals(other.ticker))
			return false;
		return true;
	}
    
	public void setFechaCreacion(Date date){
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.clear(Calendar.SECOND);
		c.clear(Calendar.MILLISECOND);
		c.clear(Calendar.MINUTE);
		c.clear(Calendar.HOUR);
		c.clear(Calendar.HOUR_OF_DAY);
		
		this.fechaCreacion = c.getTime();
	}
	
	public void setExchange(String exchange){
		
		this.exchange = exchange;
		setMarket(exchange);
	}

	public void generateOpinionAverage(){
		if(recomendacionBuy!=null||recomendacionUnderPerform!=null||recomendacionOutPerform!=null||recomendacionSell!=null){
			this.recomendacionAverage = recomendacionOutPerform.doubleValue() 
					+recomendacionBuy.doubleValue()*1.5D
					- recomendacionUnderPerform.doubleValue()
					- recomendacionSell.doubleValue()*1.5D; 
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
		return "ticker=" + ticker + ", market=" + getMercado()
				+ ", stockValue=" + stockValue
				+ ", maxPVal=" + maxForecastPercentageValue+"%"
				+ ", medPVal=" + medForecastPercentageValue+"%"
				+ ", minPVal=" + minForecastPercentageValue+"%"
				+ ", p52W=" + price52WeekPercChange
				+ ", Average=" + recomendacionAverage
				+ ", Buy=" + recomendacionBuy
				+ ", OutPerform=" + recomendacionOutPerform
				+ ", Hold=" + recomendacionHold
				+ ", UnderPerform=" + recomendacionUnderPerform
				+ ", Sell=" + recomendacionSell
				+ ", volNegociado=" + volumenNegociado + ", fechaCreacion="
				+ dateFormatted;
	}
    
    public static List<Company> findAllCompanys() {
        return entityManager().createQuery("SELECT o FROM Company o", Company.class).getResultList();
    }
    
    public String getMercado(){
    	if(exchange.equalsIgnoreCase("NYSE")){
    		return exchange;
    	}else if(exchange.equalsIgnoreCase("NASDAQ")){
    		return exchange;
    	}else if(exchange.equalsIgnoreCase("LON")){
    		return "London";
    	}else if(exchange.equalsIgnoreCase("EPA")){
    		return "Paris";
    	}else if(exchange.equalsIgnoreCase("OTCQB")){
    		return "NEW YORK, "+exchange;
    	}else if(exchange.equalsIgnoreCase("CVE")){
    		return "CANADA";
    	}else if(exchange.equalsIgnoreCase("TSE")){
    		return "CANADA, TORONTO";
    	}else if(exchange.equalsIgnoreCase("FRA")){
    		return "GERMANY, FRANKFURT";
    	}else if(exchange.equalsIgnoreCase("ETR")){
    		return "GERMANY";
    	}else if(exchange.equalsIgnoreCase("BIT")){
    		return "MILAN";
    	}else if(exchange.equalsIgnoreCase("BME")){
    		return "MADRID";
    	}else if(exchange.equalsIgnoreCase("BVMF")){
    		return "SAO PAULO";
    	}else if(exchange.equalsIgnoreCase("EBR")){
    		return "BRUSSELS";
    	}else if(exchange.equalsIgnoreCase("AMS")){
    		return "AMSTERDAM";
    	}else if(exchange.equalsIgnoreCase("ASX")){
    		return "AUSTRALIA";
    	}
    	return "INCOGNITA";
    }
    
}
