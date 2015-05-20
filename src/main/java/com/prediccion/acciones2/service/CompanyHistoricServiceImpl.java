package com.prediccion.acciones2.service;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.prediccion.acciones2.domain.Company;
import com.prediccion.acciones2.domain.CompanyHistoric;

public class CompanyHistoricServiceImpl implements CompanyHistoricService {

	@Override
	@Transactional
	public void createHistotic(List<Company> companyList) {
		Mapper mapper = new DozerBeanMapper();
		
		CompanyHistoric ch = null;
		for (Company company : companyList) {
			ch = new CompanyHistoric();
			mapper.map(company, ch);		
			/*
			ch.setCompanyId(company.getCompanyId());
			ch.setExchange(company.getExchange());
			ch.setFechaCreacion(company.getFechaCreacion());
			ch.setLocalCurrencySymbol(company.getLocalCurrencySymbol());
			ch.setMarket(company.getMarket());
			ch.setMarketCap(company.getMarketCap());
			ch.setMaxForecastPercentageValue(company.getMaxForecastPercentageValue());
			ch.setMinForecastPercentageValue(company.getMinForecastPercentageValue());
			ch.setMedForecastPercentageValue(company.getMedForecastPercentageValue());
			ch.setPe(company.getPe());
			ch.setPrice52WeekPercChange(company.getPrice52WeekPercChange());
			ch.setRecomendacionAverage(company.getRecomendacionAverage());
			ch.setRecomendacionBuy(company.getRecomendacionBuy());
			ch.setRecomendacionHold(company.getRecomendacionHold());
			ch.setRecomendacionNoOpinion(company.getRecomendacionNoOpinion());
			ch.setRecomendacionOutPerform(company.getRecomendacionOutPerform());
			ch.setRecomendacionUnderPerform(company.getRecomendacionUnderPerform());
			ch.setRecomendacionSell(company.getRecomendacionSell());
			ch.setRecomendacionNoOpinion(company.getRecomendacionNoOpinion());
			ch.setStockValue(company.getStockValue());
			ch.setTicker(company.getTicker());
			ch.setTitle(company.getTitle());
			ch.setVolumenNegociado(company.getVolumenNegociado());
			*/
			
			//ch.persist();
			ch.save();
		}
		
		for (Company company : companyList) {
			company.remove();
		}
	}

}
