package com.marto.spring.basics.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComponentDao {

  private @Autowired ComponentJdbcConnection jdbcConnection;

  public ComponentJdbcConnection getJdbcConnection() {
    return jdbcConnection;
  }

  public void setComponentJdbcConnection(ComponentJdbcConnection jdbcConnection) {
    this.jdbcConnection = jdbcConnection;
  }
}
