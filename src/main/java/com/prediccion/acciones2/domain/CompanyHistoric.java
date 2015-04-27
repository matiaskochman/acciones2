package com.prediccion.acciones2.domain;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class CompanyHistoric {

    @NotNull
    @Column
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

    @Column
    private String companyId;

    @Column
    private String localCurrencySymbol;
}
