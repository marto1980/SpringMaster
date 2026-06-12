package com.marto.spring.basics.spring_in_5_steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {
  @Autowired
  @Qualifier("bubble")
  private SortAlgorithm sortAlgorithm;

  public int binarySearch(int[] numbers, int numberToSearchFor) {

    int[] sortedNumbers = sortAlgorithm.sort(numbers);
    System.out.println(sortAlgorithm);

    // Search the array
    // Return the result
    return 3;
  }
}
