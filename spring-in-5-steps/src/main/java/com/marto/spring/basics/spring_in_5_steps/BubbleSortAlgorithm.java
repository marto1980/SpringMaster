package com.marto.spring.basics.spring_in_5_steps;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm {

  public int[] sort(int[] numbers) {
    // Logic for Bubble Sort
    return numbers;
  }
}
