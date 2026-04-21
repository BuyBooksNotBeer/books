package org.recolo.model.optionexpiration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionExpireDateResponseWrapper
{

    @JsonProperty("OptionExpireDateResponse")
    private OptionExpireDateResponse response;

    public OptionExpireDateResponse getResponse()
    {
        return response;
    }

    public void setResponse(OptionExpireDateResponse response)
    {
        this.response = response;
    }
    
    @Override
    public String toString()
    {
        return response.toString();
    }
}
