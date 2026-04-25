package org.recolo.model.quote;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Comprehensive quote details when detailFlag=ALL.
 * See: https://apisb.etrade.com/docs/api/market/api-quote-v1.html#/definitions/AllQuoteDetails
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllQuoteDetails {
    public static Logger logger = LoggerFactory.getLogger(AllQuoteDetails.class);




    
    @JsonProperty("adjustedFlag")
    private Boolean adjustedFlag;
    
    private Double ask;
    
    @JsonProperty("askSize")
    private Long askSize;
    
    private String askTime;
    
    private Double bid;
    
    private String bidExchange;
    
    @JsonProperty("bidSize")
    private Long bidSize;
    
    private String bidTime;
    
    @JsonProperty("changeClose")
    private Double changeClose;
    
    @JsonProperty("changeClosePercentage")
    private Double changeClosePercentage;
    
    @JsonProperty("companyName")
    private String companyName;
    
    @JsonProperty("daysToExpiration")
    private Long daysToExpiration;
    
    @JsonProperty("dirLast")
    private String dirLast;
    
    private Double dividend;
    
    private Double eps;
    
    @JsonProperty("estEarnings")
    private Double estEarnings;
    
    @JsonProperty("exDividendDate")
    private Long exDividendDate;
    
    private Double high;
    
    @JsonProperty("high52")
    private Double high52;
    
    @JsonProperty("lastTrade")
    private Double lastTrade;
    
    private Double low;
    
    @JsonProperty("low52")
    private Double low52;
    
    private Double open;
    
    @JsonProperty("openInterest")
    private Long openInterest;
    
    @JsonProperty("optionStyle")
    private String optionStyle;
    
    @JsonProperty("optionUnderlier")
    private String optionUnderlier;
    
    @JsonProperty("optionUnderlierExchange")
    private String optionUnderlierExchange;
    
    @JsonProperty("previousClose")
    private Double previousClose;
    
    @JsonProperty("previousDayVolume")
    private Long previousDayVolume;
    
    @JsonProperty("primaryExchange")
    private String primaryExchange;
    
    @JsonProperty("symbolDescription")
    private String symbolDescription;
    
    @JsonProperty("totalVolume")
    private Long totalVolume;
    
    private Long upc;
    
    @JsonProperty("optionDeliverableList")
    private List<OptionDeliverable> optionDeliverableList;
    
    @JsonProperty("cashDeliverable")
    private Double cashDeliverable;
    
    @JsonProperty("marketCap")
    private Double marketCap;
    
    @JsonProperty("sharesOutstanding")
    private Long sharesOutstanding;
    
    @JsonProperty("nextEarningDate")
    private String nextEarningDate;
    
    private Double beta;
    
    private Double yieldValue;  // Renamed from 'yield' (Java keyword)
    
    @JsonProperty("declaredDividend")
    private Double declaredDividend;
    
    @JsonProperty("dividendPayableDate")
    private Long dividendPayableDate;
    
    private Double pe;
    
    @JsonProperty("week52LowDate")
    private Long week52LowDate;
    
    @JsonProperty("week52HiDate")
    private Long week52HiDate;
    
    @JsonProperty("intrinsicValue")
    private Double intrinsicValue;
    
    @JsonProperty("timePremium")
    private Double timePremium;
    
    @JsonProperty("optionMultiplier")
    private Double optionMultiplier;
    
    @JsonProperty("contractSize")
    private Double contractSize;
    
    @JsonProperty("expirationDate")
    private Long expirationDate;
    
    @JsonProperty("ehQuote")  // Extended hours quote
    private ExtendedHourQuoteDetail ehQuote;
    
    @JsonProperty("optionPreviousBidPrice")
    private Double optionPreviousBidPrice;
    
    @JsonProperty("optionPreviousAskPrice")
    private Double optionPreviousAskPrice;
    
    @JsonProperty("osiKey")
    private String osiKey;
    
    @JsonProperty("timeOfLastTrade")
    private Long timeOfLastTrade;
    
    @JsonProperty("averageVolume")
    private Long averageVolume;

    // Getters & Setters (abbreviated - generate via IDE)
    public Boolean getAdjustedFlag() { return adjustedFlag; }
    public void setAdjustedFlag(Boolean adjustedFlag) { this.adjustedFlag = adjustedFlag; }
    public Double getAsk() { return ask; }
    public void setAsk(Double ask) { this.ask = ask; }
    public Long getAskSize() { return askSize; }
    public void setAskSize(Long askSize) { this.askSize = askSize; }
    public String getAskTime() { return askTime; }
    public void setAskTime(String askTime) { this.askTime = askTime; }
    public Double getBid() { return bid; }
    public void setBid(Double bid) { this.bid = bid; }
    public String getBidExchange() { return bidExchange; }
    public void setBidExchange(String bidExchange) { this.bidExchange = bidExchange; }
    public Long getBidSize() { return bidSize; }
    public void setBidSize(Long bidSize) { this.bidSize = bidSize; }
    public String getBidTime() { return bidTime; }
    public void setBidTime(String bidTime) { this.bidTime = bidTime; }
    public Double getChangeClose() { return changeClose; }
    public void setChangeClose(Double changeClose) { this.changeClose = changeClose; }
    public Double getChangeClosePercentage() { return changeClosePercentage; }
    public void setChangeClosePercentage(Double changeClosePercentage) { this.changeClosePercentage = changeClosePercentage; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public Long getDaysToExpiration() { return daysToExpiration; }
    public void setDaysToExpiration(Long daysToExpiration) { this.daysToExpiration = daysToExpiration; }
    public String getDirLast() { return dirLast; }
    public void setDirLast(String dirLast) { this.dirLast = dirLast; }
    public Double getDividend() { return dividend; }
    public void setDividend(Double dividend) { this.dividend = dividend; }
    public Double getEps() { return eps; }
    public void setEps(Double eps) { this.eps = eps; }
    public Double getEstEarnings() { return estEarnings; }
    public void setEstEarnings(Double estEarnings) { this.estEarnings = estEarnings; }
    public Long getExDividendDate() { return exDividendDate; }
    public void setExDividendDate(Long exDividendDate) { this.exDividendDate = exDividendDate; }
    public Double getHigh() { return high; }
    public void setHigh(Double high) { this.high = high; }
    public Double getHigh52() { return high52; }
    public void setHigh52(Double high52) { this.high52 = high52; }
    public Double getLastTrade() { return lastTrade; }
    public void setLastTrade(Double lastTrade) { this.lastTrade = lastTrade; }
    public Double getLow() { return low; }
    public void setLow(Double low) { this.low = low; }
    public Double getLow52() { return low52; }
    public void setLow52(Double low52) { this.low52 = low52; }
    public Double getOpen() { return open; }
    public void setOpen(Double open) { this.open = open; }
    public Long getOpenInterest() { return openInterest; }
    public void setOpenInterest(Long openInterest) { this.openInterest = openInterest; }
    public String getOptionStyle() { return optionStyle; }
    public void setOptionStyle(String optionStyle) { this.optionStyle = optionStyle; }
    public String getOptionUnderlier() { return optionUnderlier; }
    public void setOptionUnderlier(String optionUnderlier) { this.optionUnderlier = optionUnderlier; }
    public String getOptionUnderlierExchange() { return optionUnderlierExchange; }
    public void setOptionUnderlierExchange(String optionUnderlierExchange) { this.optionUnderlierExchange = optionUnderlierExchange; }
    public Double getPreviousClose() { return previousClose; }
    public void setPreviousClose(Double previousClose) { this.previousClose = previousClose; }
    public Long getPreviousDayVolume() { return previousDayVolume; }
    public void setPreviousDayVolume(Long previousDayVolume) { this.previousDayVolume = previousDayVolume; }
    public String getPrimaryExchange() { return primaryExchange; }
    public void setPrimaryExchange(String primaryExchange) { this.primaryExchange = primaryExchange; }
    public String getSymbolDescription() { return symbolDescription; }
    public void setSymbolDescription(String symbolDescription) { this.symbolDescription = symbolDescription; }
    public Long getTotalVolume() { return totalVolume; }
    public void setTotalVolume(Long totalVolume) { this.totalVolume = totalVolume; }
    public Long getUpc() { return upc; }
    public void setUpc(Long upc) { this.upc = upc; }
    public List<OptionDeliverable> getOptionDeliverableList() { return optionDeliverableList; }
    public void setOptionDeliverableList(List<OptionDeliverable> optionDeliverableList) { this.optionDeliverableList = optionDeliverableList; }
    public Double getCashDeliverable() { return cashDeliverable; }
    public void setCashDeliverable(Double cashDeliverable) { this.cashDeliverable = cashDeliverable; }
    public Double getMarketCap() { return marketCap; }
    public void setMarketCap(Double marketCap) { this.marketCap = marketCap; }
    public Long getSharesOutstanding() { return sharesOutstanding; }
    public void setSharesOutstanding(Long sharesOutstanding) { this.sharesOutstanding = sharesOutstanding; }
    public String getNextEarningDate() { return nextEarningDate; }
    public void setNextEarningDate(String nextEarningDate) { this.nextEarningDate = nextEarningDate; }
    public Double getBeta() { return beta; }
    public void setBeta(Double beta) { this.beta = beta; }
    public Double getYieldValue() { return yieldValue; }  // Note: getter renamed
    public void setYieldValue(Double yieldValue) { this.yieldValue = yieldValue; }
    public Double getDeclaredDividend() { return declaredDividend; }
    public void setDeclaredDividend(Double declaredDividend) { this.declaredDividend = declaredDividend; }
    public Long getDividendPayableDate() { return dividendPayableDate; }
    public void setDividendPayableDate(Long dividendPayableDate) { this.dividendPayableDate = dividendPayableDate; }
    public Double getPe() { return pe; }
    public void setPe(Double pe) { this.pe = pe; }
    public Long getWeek52LowDate() { return week52LowDate; }
    public void setWeek52LowDate(Long week52LowDate) { this.week52LowDate = week52LowDate; }
    public Long getWeek52HiDate() { return week52HiDate; }
    public void setWeek52HiDate(Long week52HiDate) { this.week52HiDate = week52HiDate; }
    public Double getIntrinsicValue() { return intrinsicValue; }
    public void setIntrinsicValue(Double intrinsicValue) { this.intrinsicValue = intrinsicValue; }
    public Double getTimePremium() { return timePremium; }
    public void setTimePremium(Double timePremium) { this.timePremium = timePremium; }
    public Double getOptionMultiplier() { return optionMultiplier; }
    public void setOptionMultiplier(Double optionMultiplier) { this.optionMultiplier = optionMultiplier; }
    public Double getContractSize() { return contractSize; }
    public void setContractSize(Double contractSize) { this.contractSize = contractSize; }
    public Long getExpirationDate() { return expirationDate; }
    public void setExpirationDate(Long expirationDate) { this.expirationDate = expirationDate; }
    public ExtendedHourQuoteDetail getEhQuote() { return ehQuote; }
    public void setEhQuote(ExtendedHourQuoteDetail ehQuote) { this.ehQuote = ehQuote; }
    public Double getOptionPreviousBidPrice() { return optionPreviousBidPrice; }
    public void setOptionPreviousBidPrice(Double optionPreviousBidPrice) { this.optionPreviousBidPrice = optionPreviousBidPrice; }
    public Double getOptionPreviousAskPrice() { return optionPreviousAskPrice; }
    public void setOptionPreviousAskPrice(Double optionPreviousAskPrice) { this.optionPreviousAskPrice = optionPreviousAskPrice; }
    public String getOsiKey() { return osiKey; }
    public void setOsiKey(String osiKey) { this.osiKey = osiKey; }
    public Long getTimeOfLastTrade() { return timeOfLastTrade; }
    public void setTimeOfLastTrade(Long timeOfLastTrade) { this.timeOfLastTrade = timeOfLastTrade; }
    public Long getAverageVolume() { return averageVolume; }
    public void setAverageVolume(Long averageVolume) { this.averageVolume = averageVolume; }
}