package com.marto.spring.basics.spring_in_5_steps.cdi;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Arrays;
import java.util.OptionalInt;

@Named
public class SomeCdiBusiness {
  @Inject private SomeCdiDao someCdiDao;

  public SomeCdiDao getSomeCdiDao() {
    return someCdiDao;
  }

  public void setSomeCdiDao(SomeCdiDao someCdiDao) {
    this.someCdiDao = someCdiDao;
  }

  public OptionalInt findGreatest() {
    int[] data = someCdiDao.getData();

    return Arrays.stream(data).max();
  }
}
