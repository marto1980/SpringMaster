package com.marto.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.OptionalInt;
import org.junit.jupiter.api.Test;

public class SomeBusinessImplTest {
  @Test
  void findTheGreatestFromAllData_basicScenario() {
    DataServiceStub dataService = new DataServiceStub();
    SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataService);
    OptionalInt result = someBusinessImpl.findTheGreatestFromAllData();
    int expectedResult = 25;
    assertEquals(expectedResult, result.getAsInt());
  }

  @Test
  void findTheGreatestFromAllData_withOneValue() {
    DataServiceStub2 dataService = new DataServiceStub2();
    SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataService);
    OptionalInt result = someBusinessImpl.findTheGreatestFromAllData();
    int expectedResult = 35;
    assertEquals(expectedResult, result.getAsInt());
  }
}

class DataServiceStub implements DataService {

  @Override
  public int[] retrieveAllData() {
    return new int[] {25, 15, 5};
  }
}

class DataServiceStub2 implements DataService {

  @Override
  public int[] retrieveAllData() {
    return new int[] {35};
  }
}
