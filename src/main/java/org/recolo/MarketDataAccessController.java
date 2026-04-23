package org.recolo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.recolo.model.option.OptionChainResponse;
import org.recolo.model.option.OptionChainResponseWrapper;
import org.recolo.model.option.OptionLeg;
import org.recolo.model.option.OptionPairEntry;
import org.recolo.model.optionexpiration.ExpirationDate;
import org.recolo.model.optionexpiration.OptionExpireDateResponseWrapper;
import org.recolo.oauth.OAuth1Interceptor;
import org.recolo.oauth.OAuthController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.oauth.OAuth10aService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class MarketDataAccessController
{
    public static Logger logger = LoggerFactory.getLogger(MarketDataAccessController.class);
    
    protected OAuth10aService oAuthService;
    protected OAuthController oAuthController;
    
    protected MarketDataAccessConfig config;
    
    private static final HashMap<String,String> EMPTY_HASHMAP = new HashMap<>();
    
    @Autowired
    public MarketDataAccessController(OAuth10aService oAuthService, OAuthController oAuthController, MarketDataAccessConfig config) 
    {
        this.oAuthService = oAuthService;
        this.oAuthController = oAuthController;
        this.config = config;
    }
    
    
    @CrossOrigin(origins = "*")
    @GetMapping("/optionsByStrike")
    public void getOptionStrike(HttpServletResponse response, @RequestParam(name = "symbol", defaultValue = "qqq") String symbol, @RequestParam(name = "strike") String strike, @RequestParam(name = "optionType", defaultValue = "Call") String optionType )
    {
        response.setContentType("text/csv");
        try( PrintWriter writer = response.getWriter())
        {
            RestTemplate restTemplate = serviceRestTemplate();
            if (restTemplate ==null)
            {
                logger.info("oAuth Token not ready");
                writer.println("oAuth Token not ready");      
            }
            String url = getUrl("optionexpiredate?symbol={symbol}&expiryType={expiryType}");
            
            Map<String, String> params = new HashMap<>();
            params.put("symbol", symbol);
            params.put("expiryType", "ALL");
      
            OptionExpireDateResponseWrapper optionDates = restTemplate.getForObject(url, OptionExpireDateResponseWrapper.class, params);
            logger.info("Option optionexpiredate request: {}, response: {}", url, optionDates);
            
            if (optionDates.getResponse() != null && optionDates.getResponse().getExpirationDates() !=null && optionDates.getResponse().getExpirationDates().size() > 0)
            {
                writer.println("expiration,symbol,strike,optiontype,bid,ask,last,quotetype");
                List<ExpirationDate> expirationDates = optionDates.getResponse().getExpirationDates();
                url = getUrl("optionchains?symbol={symbol}&expiryYear={expiryYear}&expiryMonth={expiryMonth}&expiryDay={expiryDay}&strikePriceNear={strikePriceNear}&chainType={chainType}&noOfStrikes=2");
                for (ExpirationDate exiration : expirationDates )
                {
                    String expiryYear = Integer.toString(exiration.getYear());
                    String expiryMonth = Integer.toString(exiration.getMonth());
                    String expiryDay = Integer.toString(exiration.getDay());
                    params = new HashMap<>();
                    params.put("symbol", symbol);
                    params.put("expiryYear", expiryYear);
                    params.put("expiryMonth", expiryMonth);
                    params.put("expiryDay", expiryDay);
                    params.put("strikePriceNear", strike);
                    params.put("chainType", optionType.toUpperCase());
                    logger.info("optionchains request for {}-{}-{} symbol {}, {} strike {}.", expiryYear, expiryMonth, expiryDay, symbol, optionType, strike);
                    OptionChainResponseWrapper optionChainWrapper = restTemplate.getForObject(url,  OptionChainResponseWrapper.class, params);
                    if (optionChainWrapper!=null && optionChainWrapper.getResponse()!=null && optionChainWrapper.getResponse().getOptionPairs()!=null)
                    {
                        OptionChainResponse optionChainResponse = optionChainWrapper.getResponse();
                        String expiration = optionChainResponse.getSelectedExpiration().toLocalDate().toString();
                        String qouteType = optionChainResponse.getQuoteType();
                        
                        List<OptionPairEntry> optionPairs = optionChainResponse.getOptionPairs();
                        OptionLeg option =  getCloestOption(optionPairs,optionType, strike);
                        if (option != null) 
                        {
                            double bid = option.getBid();
                            double ask = option.getAsk();
                            double last = option.getLastPrice();
                            // writer.println("expiration,symbol,strike,optiontype,bid,ask,last,quotetype");
                            writer.println(String.format("%s,%s,%s,%s,"
                                    + "%f,%f,%f,%s", 
                                    expiration, symbol, strike, optionType, 
                                    bid, ask, last, qouteType));
                            writer.flush();    
                        }
                    }
                    logger.info("optionchains response {}", optionChainWrapper);
                }
            }
            else
            {
                writer.println(String.format("Unable to get any {} option expirations for symbol %s", optionType, symbol));
                writer.flush();
            }
        }
        catch (IOException e)
        {
            logger.warn("Unable to handle option chain request",e);
        }
    }
    
    protected OptionLeg getCloestOption(List<OptionPairEntry> optionPairs, String optionType, String targetStrike) 
    {  
        double target = Double.parseDouble(targetStrike);
        OptionLeg bestLeg = null;
        for (OptionPairEntry optionPair : optionPairs)
        {
            OptionLeg leg; 
            if ("CALL".equalsIgnoreCase(optionType))
            {
                leg = optionPair.getCall();
            }
            else
            {
                leg = optionPair.getPut();
                
            }
            double legStrike = leg.getStrikePrice();
            if (Double.compare(legStrike, target) == 0)
            {
                return leg;
            }
            if (bestLeg == null)
            {
                bestLeg = leg;
            }
            else
            {
                if ( Math.abs(target - leg.getStrikePrice()) < Math.abs(target - bestLeg.getStrikePrice()) )
                {
                    bestLeg = leg;
                }
            }
        }
        logger.warn("Could not find an exact match for the strike {}, using option leg{}", targetStrike, bestLeg);
        return bestLeg;
        
        
    }
    
    @GetMapping("/qoute")
    public String getQuote(@RequestParam(name = "symbol", defaultValue = "qqq") String symbol)
    {
        logger.info("Quote request: {}  ", symbol);
        RestTemplate restTemplate = serviceRestTemplate();
        if (restTemplate ==null)
            return "oAuth Token not ready";

        String url = getUrl("quote/"+symbol);
        String response = restTemplate.getForObject(url, String.class, EMPTY_HASHMAP);
        logger.info("Quote request: {}, response {}", symbol, response);
        return response;
    }
    
    public RestTemplate serviceRestTemplate() {
        OAuth1AccessToken token = oAuthController.getActiveToken();
        if (token == null)
        {
            logger.info("oAuth Token not ready");
            return null;
        }
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new OAuth1Interceptor(oAuthService, token)));
        return restTemplate;
    }
    
    public String getUrl(String actionSuffix)
    {
        return config.getBaseUrl() + "/v1/market/" + actionSuffix;
    }
}
