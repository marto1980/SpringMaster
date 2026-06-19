package com.marto.learn_spring_aop.aop_example.business;

import com.marto.learn_spring_aop.aop_example.data.DataService1;
import java.util.Arrays;
import java.util.OptionalInt;
import org.springframework.stereotype.Service;

@Service
public class BusinessService1 {
  private DataService1 dataService1;

  public BusinessService1(DataService1 dataService1) {
    this.dataService1 = dataService1;
  }

  public OptionalInt calculateMax() {
    int[] data = dataService1.retrieveData();

    return Arrays.stream(data).max();
  }
}
