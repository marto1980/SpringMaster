package com.marto.spring.basics.spring_in_5_steps.basic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bubble")
public class BubbleSortAlgorithm implements SortAlgorithm {

  public int[] sort(int[] numbers) {
    // Logic for Bubble Sort
    return numbers;
  }
}
