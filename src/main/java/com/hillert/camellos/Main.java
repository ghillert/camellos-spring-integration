package com.hillert.camellos;

import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Starts the Spring Context and will in return start up an embedded FTP server
 * and the Spring Integration routes.
 *
 * @author Gunnar Hillert
 * @version 1.0
 *
 */
public class Main {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Main.class);

    /**
     * Load the Spring Application Context and start the embedded FTP Server
     *
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) {

    	LOGGER.info("Welcome to Spring Integration!");

        final AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath:META-INF/spring/spring-integration-context.xml");
        
        ctx.registerShutdownHook();

        final Scanner scanner = new Scanner(System.in);
        
        LOGGER.info("Please press 'q' + Enter to quite the application.");
        
        while (!scanner.hasNext("q"))
        {
          
        }
        
        LOGGER.info("Exiting application...bye.");
        
        System.exit(0);

    }
}
