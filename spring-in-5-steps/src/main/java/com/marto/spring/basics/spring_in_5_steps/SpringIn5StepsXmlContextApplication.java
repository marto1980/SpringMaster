package com.marto.spring.basics.spring_in_5_steps;

import com.marto.spring.basics.spring_in_5_steps.xml.XmlPersonDao;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIn5StepsXmlContextApplication {

  private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsXmlContextApplication.class);

  public static void main(String[] args) {
    // Application Context
    try (ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml")) {

      LOGGER.info(
          "Beans Loaded -> {}", Arrays.toString(applicationContext.getBeanDefinitionNames()));

      XmlPersonDao PersonDao = applicationContext.getBean(XmlPersonDao.class);
      LOGGER.info("{} {}", PersonDao, PersonDao.getXmlJdbcConnection());
    }
  }
}
