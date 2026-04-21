package org.recolo.model.optionexpiration;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionExpireDateResponse
{
    @JsonProperty("ExpirationDate")
    private List<ExpirationDate> expirationDates;

    public List<ExpirationDate> getExpirationDates()
    {
        return expirationDates;
    }

    public void setExpirationDates(List<ExpirationDate> expirationDates)
    {
        this.expirationDates = expirationDates;
    }
    
    @Override
    public String toString()
    {
        return expirationDates == null ? null : expirationDates.stream().map(Object::toString).collect(Collectors.joining(", ", "[", "]"));
    }
}
