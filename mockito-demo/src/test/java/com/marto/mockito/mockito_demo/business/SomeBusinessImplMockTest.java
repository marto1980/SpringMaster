package com.marto.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.OptionalInt;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SomeBusinessImplMockTest {
  @Test
  void findTheGreatestFromAllData_basicScenario() {
    DataService dataServiceMock = Mockito.mock(DataService.class);
    Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15, 5});
    SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
    OptionalInt result = someBusinessImpl.findTheGreatestFromAllData();
    assertEquals(25, result.getAsInt());
  }

  @Test
  void findTheGreatestFromAllData_oneValueTestScenario() {
    DataService dataServiceMock = Mockito.mock(DataService.class);
    Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});
    SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);
    OptionalInt result = someBusinessImpl.findTheGreatestFromAllData();
    assertEquals(35, result.getAsInt());
  }
}
