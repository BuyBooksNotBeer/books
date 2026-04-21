package org.recolo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarketDataAccessConfig
{
    @Value("${base.url}")
    String baseUrl;
    
    public String getBaseUrl()
    {
        return baseUrl;
    }
    
}
