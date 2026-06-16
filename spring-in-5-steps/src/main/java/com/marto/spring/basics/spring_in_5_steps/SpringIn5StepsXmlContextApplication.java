package com.marto.spring.basics.spring_in_5_steps;

import com.marto.spring.basics.spring_in_5_steps.xml.XmlPersonDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIn5StepsXmlContextApplication {

  public static void main(String[] args) {
    // Application Context
    try (ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml")) {

      XmlPersonDao xmlPersonDao = applicationContext.getBean(XmlPersonDao.class);
      System.out.println(xmlPersonDao);
      System.out.println(xmlPersonDao.getXmlJdbcConnection());
    }
  }
}
