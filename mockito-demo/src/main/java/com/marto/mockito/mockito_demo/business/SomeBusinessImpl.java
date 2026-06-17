package com.marto.mockito.mockito_demo.business;

import java.util.Arrays;
import java.util.OptionalInt;

public class SomeBusinessImpl {
  private DataService dataService;

  public OptionalInt findTheGreatestFromAllData() {
    int[] data = dataService.retrieveAllData();
    return Arrays.stream(data).max();
  }
}

interface DataService {
  int[] retrieveAllData();
}
