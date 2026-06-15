package com.marto.spring.basics.spring_in_5_steps.cdi;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
public class SomeCdiBusiness {
  @Inject private SomeCdiDao someCdiDao;

  public SomeCdiDao getSomeCdiDao() {
    return someCdiDao;
  }

  public void setSomeCdiDao(SomeCdiDao someCdiDao) {
    this.someCdiDao = someCdiDao;
  }
}
