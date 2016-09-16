package com.library.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * Created by dmitry on 16.09.16.
 */

@Configuration
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

    private final static Logger logger = LoggerFactory.getLogger(JerseyConfig.class);

//    @Autowired
//    private Environment environment;

    public JerseyConfig() {
        logger.info("JerseyConfig init");
        packages("library.controller");
    }

//    @Bean
//    public ServletRegistrationBean jerseyServlet() {
//        ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), environment.getProperty("path"));
//        registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName());
//        return registration;
//    }

}
