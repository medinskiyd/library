package com.library.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by dmitry on 16.09.16.
 */

@Configuration
public class JerseyConfig extends ResourceConfig {

    private final static Logger logger = LoggerFactory.getLogger(JerseyConfig.class);

    @Autowired
    private Environment environment;

    public JerseyConfig() {
        logger.info("JerseyConfig init");
        packages("library.controller");
    }

    @Bean
    public ServletRegistrationBean jerseyServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), environment.getProperty("path"));
        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
        return registration;
    }

}
