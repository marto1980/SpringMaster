package com.marto.spring.basics.spring_in_5_steps;

import com.marto.spring.basics.componentscan.ComponentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.marto.spring.basics.componentscan")
public class SpringIn5StepsComponentScanApplication {

  private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsScopeApplication.class);

  public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext =
        SpringApplication.run(SpringIn5StepsComponentScanApplication.class, args);
    ComponentDAO componentDao = applicationContext.getBean(ComponentDAO.class);

    LOGGER.info("{}", componentDao);
  }
}
