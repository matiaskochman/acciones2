// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.prediccion.acciones2.domain;

import com.prediccion.acciones2.domain.QueryLog;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect QueryLog_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager QueryLog.entityManager;
    
    public static final List<String> QueryLog.fieldNames4OrderClauseFilter = java.util.Arrays.asList("fechaQuery", "market", "forecastOk", "forecastFail");
    
    public static final EntityManager QueryLog.entityManager() {
        EntityManager em = new QueryLog().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long QueryLog.countQueryLogs() {
        return entityManager().createQuery("SELECT COUNT(o) FROM QueryLog o", Long.class).getSingleResult();
    }
    
    public static List<QueryLog> QueryLog.findAllQueryLogs() {
        return entityManager().createQuery("SELECT o FROM QueryLog o", QueryLog.class).getResultList();
    }
    
    public static List<QueryLog> QueryLog.findAllQueryLogs(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM QueryLog o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, QueryLog.class).getResultList();
    }
    
    public static QueryLog QueryLog.findQueryLog(Long id) {
        if (id == null) return null;
        return entityManager().find(QueryLog.class, id);
    }
    
    public static List<QueryLog> QueryLog.findQueryLogEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM QueryLog o", QueryLog.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<QueryLog> QueryLog.findQueryLogEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM QueryLog o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, QueryLog.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void QueryLog.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void QueryLog.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            QueryLog attached = QueryLog.findQueryLog(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void QueryLog.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void QueryLog.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public QueryLog QueryLog.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        QueryLog merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
