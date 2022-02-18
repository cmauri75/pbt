package com.example.pbt.logger;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static java.lang.System.Logger.Level.INFO;

@Component
public class StartupBean implements InitializingBean {
    private static final System.Logger LOGGER = System.getLogger(StartupBean.class.getName());

    public StartupBean() {
        LOGGER.log(INFO, "{0}. Constructor",1);
    }

    @Override
    public void afterPropertiesSet() {
        LOGGER.log(INFO, "3. InitializingBean");
    }

    @PostConstruct
    public void postConstruct() {
        LOGGER.log(INFO, "2. PostConstruct");
    }

}

