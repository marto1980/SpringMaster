package com.marto.spring.basics.spring_in_5_steps.cdi;

import jakarta.inject.Named;

@Named
public class SomeCdiDao {
  public int[] getData() {
    return new int[] {5, 89, 100};
  }
}
