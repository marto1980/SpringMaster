package com.marto.spring.basics.spring_in_5_steps;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIn5StepsApplication {

  public static void main(String[] args) {
    BinarySearchImpl binarySearchImpl = new BinarySearchImpl(new QuickSortAlgorithm());
    int result = binarySearchImpl.binarySearch(new int[] {12, 4, 6}, 3);
    // com.marto.spring.basics.spring_in_5_steps.BubbleSortAlgorithm@251a69d7
    // com.marto.spring.basics.spring_in_5_steps.QuickSortAlgorithm@251a69d7
    System.out.println(result);
    // SpringApplication.run(SpringIn5StepsApplication.class, args);
  }
}
