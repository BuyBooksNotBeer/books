package org.recolo.model.option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionChainResponseWrapper
{
    public static Logger logger = LoggerFactory.getLogger(OptionChainResponseWrapper.class);
    @JsonProperty("OptionChainResponse")
    private OptionChainResponse response;

    public OptionChainResponse getResponse()
    {
        return response;
    }

    public void setResponse(OptionChainResponse response)
    {
        this.response = response;
    }

    @Override
    public String toString()
    {
        return "OptionChainResponseWrapper [response=" + response + "]";
    }
    
    
}
