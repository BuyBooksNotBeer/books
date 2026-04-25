package org.recolo.oauth;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class OAuthController
{
    public static Logger logger = LoggerFactory.getLogger(OAuthController.class);
    
    private static final DateTimeFormatter DATE_TIME_FROMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    
    @Autowired
    private  OAuth10aService oauthService;
    
    @Autowired
    private String apiKey;
    
    @Autowired
    OAuthAccessTokenManager oAuthAccessTokenManager;
    
    private OAuth1RequestToken requestToken; 
    private OAuth1AccessToken accessToken;   



    @GetMapping("/login")
    public void login(HttpServletResponse response) throws IOException, ExecutionException, InterruptedException 
    {
        logger.info("OAuth login initiated");
        this.requestToken = oauthService.getRequestToken();
        LocalDateTime now = LocalDateTime.now();
        String requestTokenString = requestToken.getToken();
        String authUrl = "https://us.etrade.com/e/t/etws/authorize?key="+apiKey+"&token=" + requestTokenString;
        logger.info("OAuth verfiier Url: {} ", authUrl);
        response.setContentType("text/html");
        String loginPage = """
            <html>
                <body style="font-family: sans-serif; padding: 50px;">
                    <h2>OAuth 1.0 Authentication</h2>
                    
                    <p>1. Click the link below to authorize this application:</p>
                    <a href="%s" target="_blank" style="padding: 10px; background: #007bff; color: white; text-decoration: none; border-radius: 5px;">
                        Open Authorization Page
                    </a>
                    <br/><br/>
                    <hr/>
                    <p>2. Once you have the verification code/PIN, enter it below:</p>
                    <form action="/callback" method="POST">
                        <input type="text" name="verifier" placeholder="Enter Verification Code" required style="padding: 10px; width: 300px;">
                        <button type="submit" style="padding: 10px;">Submit Code</button>
                    </form>
                    <hr/>
                    <p>%s</p>
                </body>
            </html>
            """.formatted(authUrl, now.format(DATE_TIME_FROMATTER));
        
        PrintWriter out = response.getWriter();
        out.println(loginPage);
        out.close();
        //response.sendRedirect(authUrl);
    }

    @PostMapping("/callback")
    public void callback(HttpServletResponse response, @RequestParam("verifier") String verifier) throws IOException, ExecutionException, InterruptedException 
    {
        // Send in Verifier in exchange for Access Token
        this.accessToken = oauthService.getAccessToken(requestToken, verifier);
        oAuthAccessTokenManager.saveAccessToken(accessToken);
        
        String accessTokenString =  this.accessToken.getToken();
        
        LocalDateTime now = LocalDateTime.now();
        response.setContentType("text/html");
        String confirmation = """
            <html>
                <body style="font-family: sans-serif; padding: 50px;">
                    <h2>Authentication Successful</h2>
                   
                    <p>Click here to return to the previous previous page</p>
                    <a href="/login" style="padding: 10px; background: #007bff; color: white; text-decoration: none; border-radius: 5px;">
                        Back to Authentication
                    </a>
                    <p/>
                    <hr/>
                    <p>%s</p>
                </body>
            </html>
            """.formatted(now.format(DATE_TIME_FROMATTER));
        PrintWriter out = response.getWriter();
        out.println(confirmation);
        out.close();
    }

    public OAuth1AccessToken getActiveToken()
    {
        return oAuthAccessTokenManager.getAccessToken();
    }
}