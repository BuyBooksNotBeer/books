package org.recolo.oauth;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth10aService;

public class OAuth1Interceptor implements ClientHttpRequestInterceptor {
    public static Logger logger = LoggerFactory.getLogger(OAuth1Interceptor.class);

    private final OAuth10aService service;
    private final OAuth1AccessToken accessToken;

    public OAuth1Interceptor(OAuth10aService service, OAuth1AccessToken token) {
        this.service = service;
        this.accessToken = token;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        // Create the OAuth 1.0 Signature
        OAuthRequest oauthRequest = new OAuthRequest(Verb.valueOf(request.getMethod().name()), request.getURI().toString());
        service.signRequest(accessToken, oauthRequest);

        // Inject the generated Authorization header into the Spring Request
        oauthRequest.getHeaders().forEach(request.getHeaders()::add);

        return execution.execute(request, body);
    }

}

