package org.recolo.model.option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionPairEntry
{
    public static Logger logger = LoggerFactory.getLogger(OptionPairEntry.class);

    @JsonProperty("Call")
    private OptionLeg call;

    @JsonProperty("Put")
    private OptionLeg put;


    public OptionLeg getCall()
    {
        return call;
    }


    public void setCall(OptionLeg call)
    {
        this.call = call;
    }


    public OptionLeg getPut()
    {
        return put;
    }

    public void setPut(OptionLeg put)
    {
        this.put = put;
    }



    @Override
    public String toString()
    {
        return "OptionPairEntry [call=" + call + ", put=" + put + "]";
    }
}
