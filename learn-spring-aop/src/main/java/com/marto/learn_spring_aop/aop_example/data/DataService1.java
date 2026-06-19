package com.marto.learn_spring_aop.aop_example.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {
  public int[] retrieveData() {
    return new int[] {11, 22, 33, 44, 55};
  }
}
