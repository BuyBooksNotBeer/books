package org.recolo.model.option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OptionLeg
{
    public static Logger logger = LoggerFactory.getLogger(OptionLeg.class);

    private String optionCategory;
    private String optionRootSymbol;
    private long timeStamp;
    private boolean adjustedFlag;
    private String displaySymbol; // Human-readable: "QQQ May 08 '26 $645 Call"
    private String optionType;
    private double strikePrice;
    private String symbol;
    private double bid;
    private double ask;
    private int bidSize;
    private int askSize;
    private String inTheMoney;
    private int volume;
    private int openInterest;
    private double netChange;

    private double lastPrice;
    private String quoteDetail;
    private String osiKey;

    
    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }

    @JsonProperty("OptionGreeks")
    private OptionGreeks greeks;

    public String getOptionType()
    {
        return optionType;
    }

    public void setOptionType(String optionType)
    {
        this.optionType = optionType;
    }

    public double getStrikePrice()
    {
        return strikePrice;
    }

    public void setStrikePrice(double strikePrice)
    {
        this.strikePrice = strikePrice;
    }

    public double getBid()
    {
        return bid;
    }

    public void setBid(double bid)
    {
        this.bid = bid;
    }

    public double getAsk()
    {
        return ask;
    }

    public void setAsk(double ask)
    {
        this.ask = ask;
    }

    public double getLastPrice()
    {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice)
    {
        this.lastPrice = lastPrice;
    }

    public int getVolume()
    {
        return volume;
    }

    public void setVolume(int volume)
    {
        this.volume = volume;
    }

    public int getOpenInterest()
    {
        return openInterest;
    }

    public void setOpenInterest(int openInterest)
    {
        this.openInterest = openInterest;
    }

    public boolean isInTheMoney()
    {
        return "y".equalsIgnoreCase(inTheMoney);
    }  

    public OptionGreeks getGreeks()
    {
        return greeks;
    }

    public String getOptionCategory()
    {
        return optionCategory;
    }

    public void setOptionCategory(String optionCategory)
    {
        this.optionCategory = optionCategory;
    }

    public String getOptionRootSymbol()
    {
        return optionRootSymbol;
    }

    public void setOptionRootSymbol(String optionRootSymbol)
    {
        this.optionRootSymbol = optionRootSymbol;
    }

    public long getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    public int getBidSize()
    {
        return bidSize;
    }

    public void setBidSize(int bidSize)
    {
        this.bidSize = bidSize;
    }

    public int getAskSize()
    {
        return askSize;
    }

    public void setAskSize(int askSize)
    {
        this.askSize = askSize;
    }

    public String getQuoteDetail()
    {
        return quoteDetail;
    }

    public void setQuoteDetail(String quoteDetail)
    {
        this.quoteDetail = quoteDetail;
    }

    public void setGreeks(OptionGreeks greeks)
    {
        this.greeks = greeks;
    }

    public String getDisplaySymbol()
    {
        return displaySymbol;
    }

    public String getOsiKey()
    {
        return osiKey;
    }

    @Override
    public String toString()
    {
        return String.format("[%s %s @ %.2f [Bid: %.2f / Ask: %.2f] lastPrice: %f]", displaySymbol, optionType, strikePrice, bid, ask, lastPrice);
    }
}
