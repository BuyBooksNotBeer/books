package org.recolo.model.quote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtendedHourQuoteDetail
{
    public static Logger logger = LoggerFactory.getLogger(ExtendedHourQuoteDetail.class);

    double lastPrice;// The price of the most recent trade of a security
    double change; // number (double) The dollar value of the difference between the previous and the present executed
                   // price
    double percentChange; // number (double) The percentage value of difference between the previous and the present
                          // executed price
    double bid; // number //(double) The bid price of the symbol
    int bidSize; // integer (int64) The number of shares or contracts offered by a broker or dealer at the bid price
    int ask; // number (double) The ask price of the symbol
    int askSize; // integer (int64) The number of shares or contracts offered by a broker or dealer at the ask price
    int volume; // integer (int64) The number of shares or contracts
    int timeOfLastTrade; // integer (int64) The time when the last trade was carried out for the symbol
    String timeZone; // string The time zone corresponding to the timestamp provided in the quote response
    String quoteStatus; // string The status of the quote, either delayed or real time REALTIME, DELAYED, CLOSING,  EH_REALTIME, EH_BEFORE_OPEN, EH_CLOSED, INDICATIVE_REALTIME

}
