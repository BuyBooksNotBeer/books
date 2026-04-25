package org.recolo.model.quote;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteResponse
{
    public static Logger logger = LoggerFactory.getLogger(QuoteResponse.class);

    @JsonProperty("QuoteData")
    private List<QuoteData> quoteData;

    public List<QuoteData> getQuoteData() { return quoteData; }
    public void setQuoteData(List<QuoteData> quoteData) { this.quoteData = quoteData; }
}