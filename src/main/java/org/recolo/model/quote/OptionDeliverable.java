package org.recolo.model.quote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionDeliverable
{

    public static Logger logger = LoggerFactory.getLogger(OptionDeliverable.class);

    @JsonProperty("rootSymbol")
    private String rootSymbol;

    @JsonProperty("deliverableSymbol")
    private String deliverableSymbol;

    @JsonProperty("deliverableTypeCode")
    private String deliverableTypeCode;

    @JsonProperty("deliverableExchangeCode")
    private String deliverableExchangeCode;

    @JsonProperty("deliverableStrikePercent")
    private Double deliverableStrikePercent;

    @JsonProperty("deliverableCILShares")
    private Double deliverableCILShares;

    @JsonProperty("deliverableWholeShares")
    private Integer deliverableWholeShares;

    // Getters & Setters...
    public String getRootSymbol()
    {
        return rootSymbol;
    }

    public void setRootSymbol(String rootSymbol)
    {
        this.rootSymbol = rootSymbol;
    }

    public String getDeliverableSymbol()
    {
        return deliverableSymbol;
    }

    public void setDeliverableSymbol(String deliverableSymbol)
    {
        this.deliverableSymbol = deliverableSymbol;
    }

    public String getDeliverableTypeCode()
    {
        return deliverableTypeCode;
    }

    public void setDeliverableTypeCode(String deliverableTypeCode)
    {
        this.deliverableTypeCode = deliverableTypeCode;
    }

    public String getDeliverableExchangeCode()
    {
        return deliverableExchangeCode;
    }

    public void setDeliverableExchangeCode(String deliverableExchangeCode)
    {
        this.deliverableExchangeCode = deliverableExchangeCode;
    }

    public Double getDeliverableStrikePercent()
    {
        return deliverableStrikePercent;
    }

    public void setDeliverableStrikePercent(Double deliverableStrikePercent)
    {
        this.deliverableStrikePercent = deliverableStrikePercent;
    }

    public Double getDeliverableCILShares()
    {
        return deliverableCILShares;
    }

    public void setDeliverableCILShares(Double deliverableCILShares)
    {
        this.deliverableCILShares = deliverableCILShares;
    }

    public Integer getDeliverableWholeShares()
    {
        return deliverableWholeShares;
    }

    public void setDeliverableWholeShares(Integer deliverableWholeShares)
    {
        this.deliverableWholeShares = deliverableWholeShares;
    }
}
