package com.prediccion.acciones2.domain;
import javax.persistence.Column;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class LogCompanyQuery {

    /**
     */
    @Column(length=200000)
    private String query;

    /**
     */
    @Column(length=200000)
    private String queryResult;
}
