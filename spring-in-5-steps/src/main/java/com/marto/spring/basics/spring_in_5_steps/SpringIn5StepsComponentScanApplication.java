package com.marto.spring.basics.spring_in_5_steps;

import com.marto.spring.basics.componentscan.ComponentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.marto.spring.basics.componentscan")
@Configuration
public class SpringIn5StepsComponentScanApplication {

  private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsScopeApplication.class);

  public static void main(String[] args) {
    try (ConfigurableApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(SpringIn5StepsComponentScanApplication.class)) {

      ComponentDAO componentDao = applicationContext.getBean(ComponentDAO.class);

      LOGGER.info("{}", componentDao);
    }
  }
}
