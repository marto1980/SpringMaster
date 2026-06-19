package com.marto.learn_spring_aop.aop_example.data;

import com.marto.learn_spring_aop.aop_example.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService2 {
  @TrackTime
  public int[] retrieveData() {
    try {
      Thread.sleep(30);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return new int[] {111, 222, 333, 444, 555};
  }
}
