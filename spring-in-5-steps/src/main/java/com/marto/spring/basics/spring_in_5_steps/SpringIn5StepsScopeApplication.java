package com.marto.spring.basics.spring_in_5_steps;

import com.marto.spring.basics.spring_in_5_steps.scope.PersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringIn5StepsScopeApplication {

  private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsScopeApplication.class);

  public static void main(String[] args) {
    try (ConfigurableApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(SpringIn5StepsScopeApplication.class)) {

      PersonDao personDao = applicationContext.getBean(PersonDao.class);
      PersonDao personDao2 = applicationContext.getBean(PersonDao.class);

      LOGGER.info("{}", personDao);
      LOGGER.info("{}", personDao.getJdbcConnection());

      LOGGER.info("{}", personDao2);
      LOGGER.info("{}", personDao2.getJdbcConnection());
    }
  }
}
