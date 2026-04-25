package org.recolo.model.quote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product
{
    public static Logger logger = LoggerFactory.getLogger(Product.class);

    private String symbol;

    @JsonProperty("securityType")
    private String securityType;  

    @JsonProperty("securitySubType")
    private String securitySubType;

    @JsonProperty("callPut")
    private String callPut; // CALL, PUT (options only)

    @JsonProperty("expiryYear")
    private Integer expiryYear;

    @JsonProperty("expiryMonth")
    private Integer expiryMonth;

    @JsonProperty("expiryDay")
    private Integer expiryDay;

    @JsonProperty("strikePrice")
    private Double strikePrice;

    @JsonProperty("expiryType")
    private String expiryType;

    @JsonProperty("productId")
    private ProductId productId;

    // Getters & Setters
    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    public String getSecurityType()
    {
        return securityType;
    }

    public void setSecurityType(String securityType)
    {
        this.securityType = securityType;
    }

    public String getSecuritySubType()
    {
        return securitySubType;
    }

    public void setSecuritySubType(String securitySubType)
    {
        this.securitySubType = securitySubType;
    }

    public String getCallPut()
    {
        return callPut;
    }

    public void setCallPut(String callPut)
    {
        this.callPut = callPut;
    }

    public Integer getExpiryYear()
    {
        return expiryYear;
    }

    public void setExpiryYear(Integer expiryYear)
    {
        this.expiryYear = expiryYear;
    }

    public Integer getExpiryMonth()
    {
        return expiryMonth;
    }

    public void setExpiryMonth(Integer expiryMonth)
    {
        this.expiryMonth = expiryMonth;
    }

    public Integer getExpiryDay()
    {
        return expiryDay;
    }

    public void setExpiryDay(Integer expiryDay)
    {
        this.expiryDay = expiryDay;
    }

    public Double getStrikePrice()
    {
        return strikePrice;
    }

    public void setStrikePrice(Double strikePrice)
    {
        this.strikePrice = strikePrice;
    }

    public String getExpiryType()
    {
        return expiryType;
    }

    public void setExpiryType(String expiryType)
    {
        this.expiryType = expiryType;
    }

    public ProductId getProductId()
    {
        return productId;
    }

    public void setProductId(ProductId productId)
    {
        this.productId = productId;
    }
}
