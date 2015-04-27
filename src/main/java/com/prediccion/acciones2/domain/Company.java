package com.prediccion.acciones2.domain;
import java.util.Calendar;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.json.RooJson;
import org.springframework.transaction.annotation.Transactional;


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
		setFechaCreacion(new Date());
	}

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
    private Double price52WeekPercChange;
    @Column
    private Integer recomendacionAverage;
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
    private Double volumenNegociadoAyer;
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
    		this.market = "NYQ";
    	}else if(exchange.equalsIgnoreCase("NASDAQ")){
    		this.market = "NSQ";
    	}else if(exchange.equalsIgnoreCase("LON")){
    		this.market = "LSE";
    	}else if(exchange.equalsIgnoreCase("EPA")){
    		this.market = "PAR";
    	}else if(exchange.equalsIgnoreCase("OTCQB")){
    		this.market = "QBB";
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

	@Override
	public String toString() {
		return "ticker=" + ticker + ", market=" + exchange
				+ ", price=" + stockValue
				+ ", max=" + maxForecastPercentageValue+"%"
				+ ", med=" + medForecastPercentageValue+"%"
				+ ", min=" + minForecastPercentageValue+"%"
				+ ", opinionAvg= "+ recomendacionAverage
				+ ", price52WkPercChange=" + price52WeekPercChange
				+ ", Buy=" + recomendacionBuy
				+ ", OutPerform=" + recomendacionOutPerform
				+ ", Hold=" + recomendacionHold
				+ ", UnderPerform=" + recomendacionUnderPerform
				+ ", Sell=" + recomendacionSell
				+ ", NoOpinion=" + recomendacionNoOpinion
				+ ", title= "+title
				+ ", mercado= "+market;
	}

	public void generateOpinionAverage(){
		if(recomendacionBuy!=null||recomendacionUnderPerform!=null||recomendacionOutPerform!=null||recomendacionSell!=null){
			this.recomendacionAverage = recomendacionOutPerform +recomendacionBuy*2 -recomendacionUnderPerform-recomendacionSell*2; 
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
    
    
}
