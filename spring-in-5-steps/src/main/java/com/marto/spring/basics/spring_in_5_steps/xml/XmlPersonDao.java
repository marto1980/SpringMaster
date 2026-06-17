package com.marto.spring.basics.spring_in_5_steps.xml;

import org.springframework.stereotype.Component;

@Component
public class XmlPersonDao {

  private XmlJdbcConnection xmlJdbcConnection;

  public XmlJdbcConnection getXmlJdbcConnection() {
    return xmlJdbcConnection;
  }

  public void setXmlJdbcConnection(XmlJdbcConnection jdbcConnection) {
    this.xmlJdbcConnection = jdbcConnection;
  }
}
