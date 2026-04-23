package org.recolo.oauth;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.scribejava.core.model.OAuth1AccessToken;

public class OAuthAccessTokenManager
{
    public static Logger logger = LoggerFactory.getLogger(OAuthAccessTokenManager.class);
    
    public static final String TOKEN_FILE_NAME = "Access.token";
    
    
    protected String savePath;
    
    protected OAuth1AccessToken accessToken;
    
    public OAuthAccessTokenManager(String savePath)
    {
        this.savePath = savePath;
    }
    
    public void saveAccessToken(OAuth1AccessToken accessToken)
    {
        this.accessToken = accessToken;
        File tokenCache = new File(savePath, TOKEN_FILE_NAME);
        try(
            FileOutputStream fos = new FileOutputStream(tokenCache);
            ObjectOutputStream os = new ObjectOutputStream(fos);
        )
        {
            os.writeObject(accessToken);
            logger.info("OAuth access token written to {} ", tokenCache);
        }
        catch (FileNotFoundException e)
        {
            logger.error("FileNotFound", e);
        }
        catch (IOException e)
        {
            logger.error("Exxception saving token to " + tokenCache.getAbsolutePath() , e);
        }
        
    }
    
    public OAuth1AccessToken getAccessToken()
    {
        File tokenCache = new File(savePath, TOKEN_FILE_NAME);
        if (accessToken == null && tokenCache.exists())
        {

            try (
                    FileInputStream fis = new FileInputStream(tokenCache);
                    ObjectInputStream ois = new ObjectInputStream(fis);
            )
            {
                accessToken  = (OAuth1AccessToken) ois.readObject();
                if (accessToken == null)
                {
                    logger.info("OAuth access token could not be read from {}", tokenCache);
                }
                else
                {
                    logger.info("OAuth access token read from {} ", tokenCache);
                }
                
            }
            catch (FileNotFoundException e)
            {
                logger.error("FileNotFound", e);
            }
            catch (IOException e)
            {
                logger.error("Exception reading token from " + tokenCache.getAbsolutePath(), e);
            }
            catch (ClassNotFoundException e)
            {
                logger.error("Exception reading token from " + tokenCache.getAbsolutePath(), e);
            }

        }
        return accessToken;
    }
}
