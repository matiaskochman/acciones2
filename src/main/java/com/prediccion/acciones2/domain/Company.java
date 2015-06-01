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

import org.dozer.Mapping;
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
    @Mapping("title")
    private String title;
    @NotNull
    @Mapping("ticker")
    private String ticker;
    @NotNull
    @Mapping("market")
    private String market;
    @Column
    @Mapping("stockValue")
    private Double stockValue;
    @Column
    @Mapping("maxForecastPercentageValue")
    private Double maxForecastPercentageValue;
    @Column
    @Mapping("medForecastPercentageValue")
    private Double medForecastPercentageValue;
    @Column
    @Mapping("minForecastPercentageValue")
    private Double minForecastPercentageValue;
    @Column
    @Mapping("maxForecastValue")
    private Double maxForecastValue;
    @Column
    @Mapping("medForecastValue")
    private Double medForecastValue;
    @Column
    @Mapping("minForecastValue")
    private Double minForecastValue;
    @Column
    @Mapping("ticker")
    private Double price52WeekPercChange;
    @Column
    @Mapping("recomendacionAverage")
    private Double recomendacionAverage;
    @Column
    @Mapping("recomendacionBuy")
    private Integer recomendacionBuy;
    @Column
    @Mapping("recomendacionOutPerform")
    private Integer recomendacionOutPerform;
    @Column
    @Mapping("recomendacionHold")
    private Integer recomendacionHold;
    @Column
    @Mapping("recomendacionUnderPerform")
    private Integer recomendacionUnderPerform;
    @Column
    @Mapping("recomendacionSell")
    private Integer recomendacionSell;
    @Column
    @Mapping("recomendacionNoOpinion")
    private Integer recomendacionNoOpinion;
    @Column
    @Mapping("volumenNegociado")
    private String volumenNegociado;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Mapping("fechaCreacion")
    private Date fechaCreacion;
    @Column
    @Mapping("marketCap")
    private Double marketCap;
    @Column
    @Mapping("pe")
    private Double pe;
    @NotNull
    @Mapping("exchange")
    private String exchange;
    @Column(unique = true)
    @Mapping("companyId")
    private String companyId;
    @Column
    @Mapping("localCurrencySymbol")
    private String localCurrencySymbol;
    @Column
    @Mapping("recomendacionAverage_last_year")
    private Double recomendacionAverage_last_year;
    @Column
    @Mapping("recomendacionBuy_last_year")
    private Integer recomendacionBuy_last_year;
    @Column
    @Mapping("recomendacionOutPerform_last_year")
    private Integer recomendacionOutPerform_last_year;
    @Column
    @Mapping("recomendacionHold_last_year")
    private Integer recomendacionHold_last_year;
    @Column
    @Mapping("recomendacionUnderPerform_last_year")
    private Integer recomendacionUnderPerform_last_year;
    @Column
    @Mapping("recomendacionSell_last_year")
    private Integer recomendacionSell_last_year;
    @Column
    @Mapping("recomendacionAverage_last_3months")
    private Double recomendacionAverage_last_3months;
    @Column
    @Mapping("recomendacionBuy_last_3months")
    private Integer recomendacionBuy_last_3months;
    @Column
    @Mapping("recomendacionOutPerform_last_3months")
    private Integer recomendacionOutPerform_last_3months;
    @Column
    @Mapping("recomendacionHold_last_3months")
    private Integer recomendacionHold_last_3months;
    @Column
    @Mapping("recomendacionUnderPerform_last_3months")
    private Integer recomendacionUnderPerform_last_3months;
    @Column
    @Mapping("recomendacionSell_last_3months")
    private Integer recomendacionSell_last_3months;

    @Column
    @Mapping("recomendacionAverage_last_2months")
    private Double recomendacionAverage_last_2months;
    @Column
    @Mapping("recomendacionBuy_last_2months")
    private Integer recomendacionBuy_last_2months;
    @Column
    @Mapping("recomendacionOutPerform_last_2months")
    private Integer recomendacionOutPerform_last_2months;
    @Column
    @Mapping("recomendacionHold_last_2months")
    private Integer recomendacionHold_last_2months;
    @Column
    @Mapping("recomendacionUnderPerform_last_2months")
    private Integer recomendacionUnderPerform_last_2months;
    @Column
    @Mapping("recomendacionSell_last_2months")
    private Integer recomendacionSell_last_2months;

    @Column
    @Mapping("recomendacionAverage_last_4weeks")
    private Double recomendacionAverage_last_4weeks;
    @Column
    @Mapping("recomendacionBuy_last_4weeks")
    private Integer recomendacionBuy_last_4weeks;
    @Column
    @Mapping("recomendacionOutPerform_last_4weeks")
    private Integer recomendacionOutPerform_last_4weeks;
    @Column
    @Mapping("recomendacionHold_last_4weeks")
    private Integer recomendacionHold_last_4weeks;
    @Column
    @Mapping("recomendacionUnderPerform_last_4weeks")
    private Integer recomendacionUnderPerform_last_4weeks;
    @Column
    @Mapping("recomendacionSell_last_4weeks")
    private Integer recomendacionSell_last_4weeks;
    
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
    	}else if(exchange.equalsIgnoreCase("NZE")){
    		this.market = ":NZC";
    	}else if(exchange.equalsIgnoreCase("TPE")){
    		this.market = ":TAI";
    	}else if(exchange.equalsIgnoreCase("SGX")){
    		this.market = ":SES";
    	}else if(exchange.equalsIgnoreCase("TYO")){
    		this.market = ":TYO";
    	}else if(exchange.equalsIgnoreCase("SHA")){
    		this.market = ":SHH";
    	}else if(exchange.equalsIgnoreCase("SHE")){
    		this.market = ":SHH";
    	}else if(exchange.equalsIgnoreCase("VTX")){
    		this.market = ":VTX";
    	}else if(exchange.equalsIgnoreCase("SWX")){
    		this.market = ":SWX";
    	}else if(exchange.equalsIgnoreCase("WSE")){
    		this.market = ":WSE";
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
	public void generateOpinionAverage_last_year(){
		if(recomendacionBuy_last_year!=null||recomendacionUnderPerform_last_year!=null||recomendacionOutPerform_last_year!=null||recomendacionSell_last_year!=null){
			this.recomendacionAverage_last_year = recomendacionOutPerform_last_year.doubleValue() 
					+recomendacionBuy_last_year.doubleValue()*1.5D
					- recomendacionUnderPerform_last_year.doubleValue()
					- recomendacionSell_last_year.doubleValue()*1.5D; 
		}
		
	}
	public void generateOpinionAverage_last_3months(){
		if(recomendacionBuy_last_3months!=null||recomendacionUnderPerform_last_3months!=null||recomendacionOutPerform_last_3months!=null||recomendacionSell_last_3months!=null){
			this.recomendacionAverage_last_3months = recomendacionOutPerform_last_3months.doubleValue() 
					+recomendacionBuy_last_3months.doubleValue()*1.5D
					- recomendacionUnderPerform_last_3months.doubleValue()
					- recomendacionSell_last_3months.doubleValue()*1.5D; 
		}
		
	}
	public void generateOpinionAverage_last_2months(){
		if(recomendacionBuy_last_2months!=null||recomendacionUnderPerform_last_2months!=null||recomendacionOutPerform_last_2months!=null||recomendacionSell_last_2months!=null){
			this.recomendacionAverage_last_2months = recomendacionOutPerform_last_2months.doubleValue() 
					+recomendacionBuy_last_2months.doubleValue()*1.5D
					- recomendacionUnderPerform_last_2months.doubleValue()
					- recomendacionSell_last_2months.doubleValue()*1.5D; 
		}
		
	}

	public void generateOpinionAverage_last_4weeks(){
		if(recomendacionBuy_last_4weeks!=null||recomendacionUnderPerform_last_4weeks!=null||recomendacionOutPerform_last_4weeks!=null||recomendacionSell_last_4weeks!=null){
			this.recomendacionAverage_last_4weeks = recomendacionOutPerform_last_4weeks.doubleValue() 
					+recomendacionBuy_last_4weeks.doubleValue()*1.5D
					- recomendacionUnderPerform_last_4weeks.doubleValue()
					- recomendacionSell_last_4weeks.doubleValue()*1.5D; 
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
				+ ", Average=" + recomendacionAverage
				+ ", Average_last_Y=" + recomendacionAverage_last_year
				+ ", p52W=" + price52WeekPercChange
				+ ", Buy=" + recomendacionBuy
				+ ", OutPerform=" + recomendacionOutPerform
				+ ", Hold=" + recomendacionHold
				+ ", UnderPerform=" + recomendacionUnderPerform
				+ ", Sell_last_Y=" + recomendacionSell_last_year
				+ ", Buy_last_Y=" + recomendacionBuy_last_year
				+ ", OutPerform_last_Y=" + recomendacionOutPerform_last_year
				+ ", Hold_last_Y=" + recomendacionHold_last_year
				+ ", UnderPerform_last_Y=" + recomendacionUnderPerform_last_year
				+ ", Sell_last_Y=" + recomendacionSell_last_year
				
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
    	}else if(exchange.equalsIgnoreCase("NZE")){
    		return "NEW ZELAND";
    	}else if(exchange.equalsIgnoreCase("TPE")){
    		return "TAIWAN";
    	}else if(exchange.equalsIgnoreCase("SGX")){
    		return "SINGAPORE";
    	}else if(exchange.equalsIgnoreCase("TYO")){
    		return "TOKYO";
    	}else if(exchange.equalsIgnoreCase("SHA")){
    		return "SHANGAI";
    	}else if(exchange.equalsIgnoreCase("SHE")){
    		return "CHINA";
    	}else if(exchange.equalsIgnoreCase("VTX")){
    		return "SWISS";
    	}else if(exchange.equalsIgnoreCase("SWX")){
    		return "SWISS";
    	}else if(exchange.equalsIgnoreCase("WSE")){
    		return "POLAND";
    	}
    	return "INCOGNITA";
    }
    
}
