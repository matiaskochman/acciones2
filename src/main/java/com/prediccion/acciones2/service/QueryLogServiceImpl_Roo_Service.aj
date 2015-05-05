// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.prediccion.acciones2.service;

import com.prediccion.acciones2.domain.QueryLog;
import com.prediccion.acciones2.service.QueryLogServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect QueryLogServiceImpl_Roo_Service {
    
    declare @type: QueryLogServiceImpl: @Service;
    
    declare @type: QueryLogServiceImpl: @Transactional;
    
    public long QueryLogServiceImpl.countAllQueryLogs() {
        return QueryLog.countQueryLogs();
    }
    
    public void QueryLogServiceImpl.deleteQueryLog(QueryLog queryLog) {
        queryLog.remove();
    }
    
    public QueryLog QueryLogServiceImpl.findQueryLog(Long id) {
        return QueryLog.findQueryLog(id);
    }
    
    public List<QueryLog> QueryLogServiceImpl.findAllQueryLogs() {
        return QueryLog.findAllQueryLogs();
    }
    
    public List<QueryLog> QueryLogServiceImpl.findQueryLogEntries(int firstResult, int maxResults) {
        return QueryLog.findQueryLogEntries(firstResult, maxResults);
    }
    
    public void QueryLogServiceImpl.saveQueryLog(QueryLog queryLog) {
        queryLog.persist();
    }
    
    public QueryLog QueryLogServiceImpl.updateQueryLog(QueryLog queryLog) {
        return queryLog.merge();
    }
    
}