package org.recolo.oauth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth10aService;

@Configuration
public class OAuthClientConfig
{
    public static Logger logger = LoggerFactory.getLogger(OAuthClientConfig.class);
    
    @Value("${base.url}")
    String baseUrl;
    
    @Value("${consumer.key}")
    String consumerKey;
    
    @Value("${consumer.secret}")
    String consumerSecret;
    
    @Value("${accessTokenCachePath:.}")
    String accessTokenCachePath;

    @Bean
    public OAuthAccessTokenManager getOAuthAccessTokenManager()
    {
        return new OAuthAccessTokenManager(accessTokenCachePath);
    }
    
    @Bean
    public ETradeServiceApi getETradeServiceApi()
    {
        return new ETradeServiceApi(baseUrl);
        
    }
    
    @Bean 
    public OAuth10aService getOAuth10aService(ETradeServiceApi getDefaultApi10a)
    {
        logger.info("creatingOAuthService baseURL {}", baseUrl );
        OAuth10aService service = new ServiceBuilder(consumerKey)
                .apiSecret(consumerSecret)
                .callback("oob")
                .build(getDefaultApi10a);
        return service;
    }
    
    @Bean 
    public String getApiKey()
    {
        return consumerKey;
    }
    

}