package com.marto.spring.basics.spring_in_5_steps.xml;

import org.springframework.stereotype.Component;

@Component
public class XmlJdbcConnection {
  public XmlJdbcConnection() {
    System.out.println("JDBC Connection");
  }
}
