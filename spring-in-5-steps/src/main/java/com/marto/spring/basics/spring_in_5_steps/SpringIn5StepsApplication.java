package com.marto.spring.basics.spring_in_5_steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIn5StepsApplication {

  public static void main(String[] args) {
    BinarySearchImpl binarySearchImpl = new BinarySearchImpl();
    int result = binarySearchImpl.binarySearch(new int[] {12, 4, 6}, 3);
    System.out.println(result);
    SpringApplication.run(SpringIn5StepsApplication.class, args);
  }
}
