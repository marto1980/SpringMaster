package com.marto.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.OptionalInt;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {
  @Mock private DataService dataServiceMock;
  @InjectMocks private SomeBusinessImpl businessImpl;

  @Test
  void findTheGreatestFromAllData_basicScenario() {
    Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15, 5});
    OptionalInt result = businessImpl.findTheGreatestFromAllData();
    assertEquals(25, result.getAsInt());
  }

  @Test
  void findTheGreatestFromAllData_oneValue() {
    Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});
    OptionalInt result = businessImpl.findTheGreatestFromAllData();
    assertEquals(35, result.getAsInt());
  }

  @Test
  void findTheGreatestFromAllData_EmptyArray() {
    Mockito.when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
    OptionalInt result = businessImpl.findTheGreatestFromAllData();
    assertTrue(result.isEmpty());
  }
}
