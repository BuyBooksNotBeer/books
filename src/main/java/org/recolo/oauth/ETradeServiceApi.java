package org.recolo.oauth;

import com.github.scribejava.core.builder.api.DefaultApi10a;

public class ETradeServiceApi extends DefaultApi10a {
    
    public final String eTradeBaseUrl;

    public ETradeServiceApi(String eTradeBaseUrl) 
    {
        this.eTradeBaseUrl = eTradeBaseUrl;
    }


    @Override
    public String getAccessTokenEndpoint() {
        return eTradeBaseUrl + "/oauth/access_token";
    }

    @Override
    public String getRequestTokenEndpoint() {
        return "https://api.etrade.com/oauth/request_token";
    }

    @Override
    public String getAuthorizationBaseUrl() {
        return "https://us.etrade.com/e/t/etws/authorize";
    }
}

