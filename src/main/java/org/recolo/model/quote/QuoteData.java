package org.recolo.model.quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteData
{
    public static Logger logger = LoggerFactory.getLogger(QuoteData.class);
    

    @JsonProperty("All")  // Note: JSON key is uppercase "All"
    private AllQuoteDetails all;
    
    private String dateTime;
    
    @JsonProperty("dateTimeUTC")
    private Long dateTimeUtc;
    
    private String quoteStatus;  // REALTIME, DELAYED, CLOSING, etc.
    
    private String ahFlag;       // "true"/"false" as string per API spec
    
    private String errorMessage;
    
    @JsonProperty("hasMiniOptions")
    private Boolean hasMiniOptions;
    
    @JsonProperty("Product")
    private Product product;
    

    // Getters & Setters
    public AllQuoteDetails getAll() { return all; }
    public void setAll(AllQuoteDetails all) { this.all = all; }
    
    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }
    
    public Long getDateTimeUtc() { return dateTimeUtc; }
    public void setDateTimeUtc(Long dateTimeUtc) { this.dateTimeUtc = dateTimeUtc; }
    
    public String getQuoteStatus() { return quoteStatus; }
    public void setQuoteStatus(String quoteStatus) { this.quoteStatus = quoteStatus; }
    
    public String getAhFlag() { return ahFlag; }
    public void setAhFlag(String ahFlag) { this.ahFlag = ahFlag; }
    
    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
    
    public Boolean getHasMiniOptions() { return hasMiniOptions; }
    public void setHasMiniOptions(Boolean hasMiniOptions) { this.hasMiniOptions = hasMiniOptions; }
    
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}

