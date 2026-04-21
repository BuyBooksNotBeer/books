package org.recolo.model.option;
import java.util.List;
import java.util.stream.Collectors;

import org.recolo.model.optionexpiration.ExpirationDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionChainResponse {

    public static Logger logger = LoggerFactory.getLogger(OptionChainResponse.class);
    
    private long timeStamp;           // The option chain response timestamp
    private String quoteType;         // "CLOSING", "DELAYED", etc.
    private double nearPrice;         // The near price in the option chain

    @JsonProperty("OptionPair")
    private List<OptionPairEntry> optionPairs;   

    @JsonProperty("SelectedED")
    private ExpirationDate selectedExpiration;  // Selected expiration date

    // Getters & Setters
    public long getTimeStamp() { return timeStamp; }
    public void setTimeStamp(long timeStamp) { this.timeStamp = timeStamp; }
    
    public String getQuoteType() { return quoteType; }
    public void setQuoteType(String quoteType) { this.quoteType = quoteType; }
    
    public double getNearPrice() { return nearPrice; }
    public void setNearPrice(double nearPrice) { this.nearPrice = nearPrice; }
    
    public List<OptionPairEntry> getOptionPairs() { return optionPairs; }
    public void setOptionPairs(List<OptionPairEntry> pairs) { this.optionPairs = pairs; }
    
    public ExpirationDate getSelectedExpiration() { return selectedExpiration; }
    public void setSelectedExpiration(ExpirationDate date) { this.selectedExpiration = date; }
    
    @Override
    public String toString()
    {
        String optionPairsString = optionPairs == null ? "" : optionPairs.stream().map(Object::toString).collect(Collectors.joining(", ", "[", "]"));
        return "OptionChainResponse [timeStamp=" + timeStamp + ", quoteType=" + quoteType + ", nearPrice=" + nearPrice + ", optionPairs=" + optionPairsString
                + ", selectedExpiration=" + selectedExpiration + "]";
    }
}