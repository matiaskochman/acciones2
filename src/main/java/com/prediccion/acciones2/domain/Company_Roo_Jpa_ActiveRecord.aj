// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.prediccion.acciones2.domain;

import com.prediccion.acciones2.domain.Company;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Company_Roo_Jpa_ActiveRecord {
    
    public static final List<String> Company.fieldNames4OrderClauseFilter = java.util.Arrays.asList("entityManager", "title", "ticker", "market", "stockValue", "maxForecastPercentageValue", "medForecastPercentageValue", "minForecastPercentageValue", "maxForecastValue", "medForecastValue", "minForecastValue", "price52WeekPercChange", "recomendacionAverage", "recomendacionBuy", "recomendacionOutPerform", "recomendacionHold", "recomendacionUnderPerform", "recomendacionSell", "recomendacionNoOpinion", "volumenNegociado", "fechaCreacion", "marketCap", "pe", "exchange", "companyId", "localCurrencySymbol");
    
    public static final EntityManager Company.entityManager() {
        EntityManager em = new Company().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Company.countCompanys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Company o", Long.class).getSingleResult();
    }
    
    public static List<Company> Company.findAllCompanys(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Company o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Company.class).getResultList();
    }
    
    public static Company Company.findCompany(Long id) {
        if (id == null) return null;
        return entityManager().find(Company.class, id);
    }
    
    public static List<Company> Company.findCompanyEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Company o", Company.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Company> Company.findCompanyEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Company o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Company.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Company.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Company.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Company attached = Company.findCompany(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Company.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Company.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Company Company.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Company merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
