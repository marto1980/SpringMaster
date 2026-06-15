package com.marto.spring.basics.spring_in_5_steps;

import com.marto.spring.basics.spring_in_5_steps.cdi.SomeCdiBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringIn5StepsCdiApplication {

  private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsCdiApplication.class);

  public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(SpringIn5StepsCdiApplication.class);
    SomeCdiBusiness business = applicationContext.getBean(SomeCdiBusiness.class);
    LOGGER.info("{} dao-{}", business, business.getSomeCdiDao());
    applicationContext.close();
  }
}
