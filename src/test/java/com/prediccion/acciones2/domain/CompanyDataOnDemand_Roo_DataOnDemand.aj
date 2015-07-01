// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.prediccion.acciones2.domain;

import com.prediccion.acciones2.domain.Company;
import com.prediccion.acciones2.domain.CompanyDataOnDemand;
import com.prediccion.acciones2.service.CompanyService;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect CompanyDataOnDemand_Roo_DataOnDemand {
    
    declare @type: CompanyDataOnDemand: @Component;
    
    private Random CompanyDataOnDemand.rnd = new SecureRandom();
    
    private List<Company> CompanyDataOnDemand.data;
    
    @Autowired
    CompanyService CompanyDataOnDemand.companyService;
    
    public Company CompanyDataOnDemand.getNewTransientCompany(int index) {
        Company obj = new Company();
        setCity(obj, index);
        setCompanyId(obj, index);
        setEntityManager(obj, index);
        setExchange(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setLocalCurrencySymbol(obj, index);
        setMarket(obj, index);
        setMarketCap(obj, index);
        setMaxForecastPercentageValue(obj, index);
        setMaxForecastValue(obj, index);
        setMedForecastPercentageValue(obj, index);
        setMedForecastValue(obj, index);
        setMinForecastPercentageValue(obj, index);
        setMinForecastValue(obj, index);
        setPe(obj, index);
        setPrice52WeekPercChange(obj, index);
        setRecomendacionAverage(obj, index);
        setRecomendacionAverage_last_2months(obj, index);
        setRecomendacionAverage_last_3months(obj, index);
        setRecomendacionAverage_last_4weeks(obj, index);
        setRecomendacionAverage_last_year(obj, index);
        setRecomendacionBuy(obj, index);
        setRecomendacionBuy_last_2months(obj, index);
        setRecomendacionBuy_last_3months(obj, index);
        setRecomendacionBuy_last_4weeks(obj, index);
        setRecomendacionBuy_last_year(obj, index);
        setRecomendacionHold(obj, index);
        setRecomendacionHold_last_2months(obj, index);
        setRecomendacionHold_last_3months(obj, index);
        setRecomendacionHold_last_4weeks(obj, index);
        setRecomendacionHold_last_year(obj, index);
        setRecomendacionNoOpinion(obj, index);
        setRecomendacionOutPerform(obj, index);
        setRecomendacionOutPerform_last_2months(obj, index);
        setRecomendacionOutPerform_last_3months(obj, index);
        setRecomendacionOutPerform_last_4weeks(obj, index);
        setRecomendacionOutPerform_last_year(obj, index);
        setRecomendacionSell(obj, index);
        setRecomendacionSell_last_2months(obj, index);
        setRecomendacionSell_last_3months(obj, index);
        setRecomendacionSell_last_4weeks(obj, index);
        setRecomendacionSell_last_year(obj, index);
        setRecomendacionUnderPerform(obj, index);
        setRecomendacionUnderPerform_last_2months(obj, index);
        setRecomendacionUnderPerform_last_3months(obj, index);
        setRecomendacionUnderPerform_last_4weeks(obj, index);
        setRecomendacionUnderPerform_last_year(obj, index);
        setStockValue(obj, index);
        setTicker(obj, index);
        setTitle(obj, index);
        setVolumenNegociado(obj, index);
        return obj;
    }
    
    public void CompanyDataOnDemand.setCity(Company obj, int index) {
        String city = "city_" + index;
        obj.setCity(city);
    }
    
    public void CompanyDataOnDemand.setCompanyId(Company obj, int index) {
        String companyId = "companyId_" + index;
        obj.setCompanyId(companyId);
    }
    
    public void CompanyDataOnDemand.setEntityManager(Company obj, int index) {
        EntityManager entityManager = null;
        obj.setEntityManager(entityManager);
    }
    
    public void CompanyDataOnDemand.setExchange(Company obj, int index) {
        String exchange = "exchange_" + index;
        obj.setExchange(exchange);
    }
    
    public void CompanyDataOnDemand.setFechaCreacion(Company obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }
    
    public void CompanyDataOnDemand.setFechaModificacion(Company obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }
    
    public void CompanyDataOnDemand.setLocalCurrencySymbol(Company obj, int index) {
        String localCurrencySymbol = "localCurrencySymbol_" + index;
        obj.setLocalCurrencySymbol(localCurrencySymbol);
    }
    
    public void CompanyDataOnDemand.setMarket(Company obj, int index) {
        String market = "market_" + index;
        obj.setMarket(market);
    }
    
    public void CompanyDataOnDemand.setMarketCap(Company obj, int index) {
    	String marketCap = "marketCap_"+index;

        obj.setMarketCap(marketCap);
    }
    
    public void CompanyDataOnDemand.setMaxForecastPercentageValue(Company obj, int index) {
        Double maxForecastPercentageValue = new Integer(index).doubleValue();
        obj.setMaxForecastPercentageValue(maxForecastPercentageValue);
    }
    
    public void CompanyDataOnDemand.setMaxForecastValue(Company obj, int index) {
        Double maxForecastValue = new Integer(index).doubleValue();
        obj.setMaxForecastValue(maxForecastValue);
    }
    
    public void CompanyDataOnDemand.setMedForecastPercentageValue(Company obj, int index) {
        Double medForecastPercentageValue = new Integer(index).doubleValue();
        obj.setMedForecastPercentageValue(medForecastPercentageValue);
    }
    
    public void CompanyDataOnDemand.setMedForecastValue(Company obj, int index) {
        Double medForecastValue = new Integer(index).doubleValue();
        obj.setMedForecastValue(medForecastValue);
    }
    
    public void CompanyDataOnDemand.setMinForecastPercentageValue(Company obj, int index) {
        Double minForecastPercentageValue = new Integer(index).doubleValue();
        obj.setMinForecastPercentageValue(minForecastPercentageValue);
    }
    
    public void CompanyDataOnDemand.setMinForecastValue(Company obj, int index) {
        Double minForecastValue = new Integer(index).doubleValue();
        obj.setMinForecastValue(minForecastValue);
    }
    
    public void CompanyDataOnDemand.setPe(Company obj, int index) {
        Double pe = new Integer(index).doubleValue();
        obj.setPe(pe);
    }
    
    public void CompanyDataOnDemand.setPrice52WeekPercChange(Company obj, int index) {
        Double price52WeekPercChange = new Integer(index).doubleValue();
        obj.setPrice52WeekPercChange(price52WeekPercChange);
    }
    
    public void CompanyDataOnDemand.setRecomendacionAverage(Company obj, int index) {
        Double recomendacionAverage = new Integer(index).doubleValue();
        obj.setRecomendacionAverage(recomendacionAverage);
    }
    
    public void CompanyDataOnDemand.setRecomendacionAverage_last_2months(Company obj, int index) {
        Double recomendacionAverage_last_2months = new Integer(index).doubleValue();
        obj.setRecomendacionAverage_last_2months(recomendacionAverage_last_2months);
    }
    
    public void CompanyDataOnDemand.setRecomendacionAverage_last_3months(Company obj, int index) {
        Double recomendacionAverage_last_3months = new Integer(index).doubleValue();
        obj.setRecomendacionAverage_last_3months(recomendacionAverage_last_3months);
    }
    
    public void CompanyDataOnDemand.setRecomendacionAverage_last_4weeks(Company obj, int index) {
        Double recomendacionAverage_last_4weeks = new Integer(index).doubleValue();
        obj.setRecomendacionAverage_last_4weeks(recomendacionAverage_last_4weeks);
    }
    
    public void CompanyDataOnDemand.setRecomendacionAverage_last_year(Company obj, int index) {
        Double recomendacionAverage_last_year = new Integer(index).doubleValue();
        obj.setRecomendacionAverage_last_year(recomendacionAverage_last_year);
    }
    
    public void CompanyDataOnDemand.setRecomendacionBuy(Company obj, int index) {
        Integer recomendacionBuy = new Integer(index);
        obj.setRecomendacionBuy(recomendacionBuy);
    }
    
    public void CompanyDataOnDemand.setRecomendacionBuy_last_2months(Company obj, int index) {
        Integer recomendacionBuy_last_2months = new Integer(index);
        obj.setRecomendacionBuy_last_2months(recomendacionBuy_last_2months);
    }
    
    public void CompanyDataOnDemand.setRecomendacionBuy_last_3months(Company obj, int index) {
        Integer recomendacionBuy_last_3months = new Integer(index);
        obj.setRecomendacionBuy_last_3months(recomendacionBuy_last_3months);
    }
    
    public void CompanyDataOnDemand.setRecomendacionBuy_last_4weeks(Company obj, int index) {
        Integer recomendacionBuy_last_4weeks = new Integer(index);
        obj.setRecomendacionBuy_last_4weeks(recomendacionBuy_last_4weeks);
    }
    
    public void CompanyDataOnDemand.setRecomendacionBuy_last_year(Company obj, int index) {
        Integer recomendacionBuy_last_year = new Integer(index);
        obj.setRecomendacionBuy_last_year(recomendacionBuy_last_year);
    }
    
    public void CompanyDataOnDemand.setRecomendacionHold(Company obj, int index) {
        Integer recomendacionHold = new Integer(index);
        obj.setRecomendacionHold(recomendacionHold);
    }
    
    public void CompanyDataOnDemand.setRecomendacionHold_last_2months(Company obj, int index) {
        Integer recomendacionHold_last_2months = new Integer(index);
        obj.setRecomendacionHold_last_2months(recomendacionHold_last_2months);
    }
    
    public void CompanyDataOnDemand.setRecomendacionHold_last_3months(Company obj, int index) {
        Integer recomendacionHold_last_3months = new Integer(index);
        obj.setRecomendacionHold_last_3months(recomendacionHold_last_3months);
    }
    
    public void CompanyDataOnDemand.setRecomendacionHold_last_4weeks(Company obj, int index) {
        Integer recomendacionHold_last_4weeks = new Integer(index);
        obj.setRecomendacionHold_last_4weeks(recomendacionHold_last_4weeks);
    }
    
    public void CompanyDataOnDemand.setRecomendacionHold_last_year(Company obj, int index) {
        Integer recomendacionHold_last_year = new Integer(index);
        obj.setRecomendacionHold_last_year(recomendacionHold_last_year);
    }
    
    public void CompanyDataOnDemand.setRecomendacionNoOpinion(Company obj, int index) {
        Integer recomendacionNoOpinion = new Integer(index);
        obj.setRecomendacionNoOpinion(recomendacionNoOpinion);
    }
    
    public void CompanyDataOnDemand.setRecomendacionOutPerform(Company obj, int index) {
        Integer recomendacionOutPerform = new Integer(index);
        obj.setRecomendacionOutPerform(recomendacionOutPerform);
    }
    
    public void CompanyDataOnDemand.setRecomendacionOutPerform_last_2months(Company obj, int index) {
        Integer recomendacionOutPerform_last_2months = new Integer(index);
        obj.setRecomendacionOutPerform_last_2months(recomendacionOutPerform_last_2months);
    }
    
    public void CompanyDataOnDemand.setRecomendacionOutPerform_last_3months(Company obj, int index) {
        Integer recomendacionOutPerform_last_3months = new Integer(index);
        obj.setRecomendacionOutPerform_last_3months(recomendacionOutPerform_last_3months);
    }
    
    public void CompanyDataOnDemand.setRecomendacionOutPerform_last_4weeks(Company obj, int index) {
        Integer recomendacionOutPerform_last_4weeks = new Integer(index);
        obj.setRecomendacionOutPerform_last_4weeks(recomendacionOutPerform_last_4weeks);
    }
    
    public void CompanyDataOnDemand.setRecomendacionOutPerform_last_year(Company obj, int index) {
        Integer recomendacionOutPerform_last_year = new Integer(index);
        obj.setRecomendacionOutPerform_last_year(recomendacionOutPerform_last_year);
    }
    
    public void CompanyDataOnDemand.setRecomendacionSell(Company obj, int index) {
        Integer recomendacionSell = new Integer(index);
        obj.setRecomendacionSell(recomendacionSell);
    }
    
    public void CompanyDataOnDemand.setRecomendacionSell_last_2months(Company obj, int index) {
        Integer recomendacionSell_last_2months = new Integer(index);
        obj.setRecomendacionSell_last_2months(recomendacionSell_last_2months);
    }
    
    public void CompanyDataOnDemand.setRecomendacionSell_last_3months(Company obj, int index) {
        Integer recomendacionSell_last_3months = new Integer(index);
        obj.setRecomendacionSell_last_3months(recomendacionSell_last_3months);
    }
    
    public void CompanyDataOnDemand.setRecomendacionSell_last_4weeks(Company obj, int index) {
        Integer recomendacionSell_last_4weeks = new Integer(index);
        obj.setRecomendacionSell_last_4weeks(recomendacionSell_last_4weeks);
    }
    
    public void CompanyDataOnDemand.setRecomendacionSell_last_year(Company obj, int index) {
        Integer recomendacionSell_last_year = new Integer(index);
        obj.setRecomendacionSell_last_year(recomendacionSell_last_year);
    }
    
    public void CompanyDataOnDemand.setRecomendacionUnderPerform(Company obj, int index) {
        Integer recomendacionUnderPerform = new Integer(index);
        obj.setRecomendacionUnderPerform(recomendacionUnderPerform);
    }
    
    public void CompanyDataOnDemand.setRecomendacionUnderPerform_last_2months(Company obj, int index) {
        Integer recomendacionUnderPerform_last_2months = new Integer(index);
        obj.setRecomendacionUnderPerform_last_2months(recomendacionUnderPerform_last_2months);
    }
    
    public void CompanyDataOnDemand.setRecomendacionUnderPerform_last_3months(Company obj, int index) {
        Integer recomendacionUnderPerform_last_3months = new Integer(index);
        obj.setRecomendacionUnderPerform_last_3months(recomendacionUnderPerform_last_3months);
    }
    
    public void CompanyDataOnDemand.setRecomendacionUnderPerform_last_4weeks(Company obj, int index) {
        Integer recomendacionUnderPerform_last_4weeks = new Integer(index);
        obj.setRecomendacionUnderPerform_last_4weeks(recomendacionUnderPerform_last_4weeks);
    }
    
    public void CompanyDataOnDemand.setRecomendacionUnderPerform_last_year(Company obj, int index) {
        Integer recomendacionUnderPerform_last_year = new Integer(index);
        obj.setRecomendacionUnderPerform_last_year(recomendacionUnderPerform_last_year);
    }
    
    public void CompanyDataOnDemand.setStockValue(Company obj, int index) {
        Double stockValue = new Integer(index).doubleValue();
        obj.setStockValue(stockValue);
    }
    
    public void CompanyDataOnDemand.setTicker(Company obj, int index) {
        String ticker = "ticker_" + index;
        obj.setTicker(ticker);
    }
    
    public void CompanyDataOnDemand.setTitle(Company obj, int index) {
        String title = "title_" + index;
        obj.setTitle(title);
    }
    
    public void CompanyDataOnDemand.setVolumenNegociado(Company obj, int index) {
        String volumenNegociado = "volumenNegociado_" + index;
        obj.setVolumenNegociado(volumenNegociado);
    }
    
    public Company CompanyDataOnDemand.getSpecificCompany(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Company obj = data.get(index);
        Long id = obj.getId();
        return companyService.findCompany(id);
    }
    
    public Company CompanyDataOnDemand.getRandomCompany() {
        init();
        Company obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return companyService.findCompany(id);
    }
    
    public boolean CompanyDataOnDemand.modifyCompany(Company obj) {
        return false;
    }
    
    public void CompanyDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = companyService.findCompanyEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Company' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Company>();
        for (int i = 0; i < 10; i++) {
            Company obj = getNewTransientCompany(i);
            try {
                companyService.saveCompany(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}
