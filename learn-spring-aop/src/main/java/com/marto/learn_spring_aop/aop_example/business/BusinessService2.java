package com.marto.learn_spring_aop.aop_example.business;

import com.marto.learn_spring_aop.aop_example.data.DataService2;
import java.util.Arrays;
import java.util.OptionalInt;
import org.springframework.stereotype.Service;

@Service
public class BusinessService2 {
  private DataService2 dataService2;

  public BusinessService2(DataService2 dataService2) {
    this.dataService2 = dataService2;
  }

  public OptionalInt calculateMin() {
    int[] data = dataService2.retrieveData();

    // throw new RuntimeException("Something Went Wrong!");
    return Arrays.stream(data).min();
  }
}
