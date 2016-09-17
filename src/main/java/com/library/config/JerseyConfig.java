package com.library.config;

import com.library.controller.LibraryController;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.ws.rs.ApplicationPath;


/**
 * Created by dmitry on 16.09.16.
 */

@Configuration
@ApplicationPath("/jersey")
public class JerseyConfig extends ResourceConfig {

    private final static Logger logger = LoggerFactory.getLogger(JerseyConfig.class);

    @Autowired
    private Environment environment;

    public JerseyConfig() {
        logger.info("JerseyConfig init");
        packages("library.controller");
        register(LibraryController.class);
    }
}
