// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.prediccion.acciones2.domain;

import com.prediccion.acciones2.domain.QueryLog;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect QueryLog_Roo_Json {
    
    public String QueryLog.toJson() {
        return new JSONSerializer()
        .exclude("*.class").serialize(this);
    }
    
    public String QueryLog.toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(this);
    }
    
    public static QueryLog QueryLog.fromJsonToQueryLog(String json) {
        return new JSONDeserializer<QueryLog>()
        .use(null, QueryLog.class).deserialize(json);
    }
    
    public static String QueryLog.toJsonArray(Collection<QueryLog> collection) {
        return new JSONSerializer()
        .exclude("*.class").serialize(collection);
    }
    
    public static String QueryLog.toJsonArray(Collection<QueryLog> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").serialize(collection);
    }
    
    public static Collection<QueryLog> QueryLog.fromJsonArrayToQueryLogs(String json) {
        return new JSONDeserializer<List<QueryLog>>()
        .use("values", QueryLog.class).deserialize(json);
    }
    
}