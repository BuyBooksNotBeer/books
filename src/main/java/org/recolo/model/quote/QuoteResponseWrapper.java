package org.recolo.model.quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//1. ROOT WRAPPER
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteResponseWrapper
{
    public static Logger logger = LoggerFactory.getLogger(QuoteResponseWrapper.class);
    
    @JsonProperty("QuoteResponse")
    private QuoteResponse quoteResponse;

    public QuoteResponse getQuoteResponse() { return quoteResponse; }
    public void setQuoteResponse(QuoteResponse quoteResponse) { this.quoteResponse = quoteResponse; }
}
