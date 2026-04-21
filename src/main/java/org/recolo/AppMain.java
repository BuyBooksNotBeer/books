package org.recolo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AppMain  
{
    
    public static Logger logger = LoggerFactory.getLogger(AppMain.class);
    
    public static void main(String[] args)
    {
        System.out.println("Hello World - Starting SpringBoot AppMain");
        logger.info("Hello World - Starting SpringBoot AppMain");
        
        SpringApplication.run(AppMain.class, args);
    }
    
    
}
