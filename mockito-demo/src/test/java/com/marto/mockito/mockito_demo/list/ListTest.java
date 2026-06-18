package com.marto.mockito.mockito_demo.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ListTest {

  @Test
  public void simpleTest() {
    List<Integer> listMock = mock(List.class);
    when(listMock.size()).thenReturn(3);
    assertEquals(3, listMock.size());
  }

  @Test
  public void multipleReturnsTest() {
    List<Integer> listMock = mock(List.class);
    when(listMock.size()).thenReturn(1).thenReturn(2);
    assertEquals(1, listMock.size());
    assertEquals(2, listMock.size());
    assertEquals(2, listMock.size());
    assertEquals(2, listMock.size());
    assertEquals(2, listMock.size());
  }

  @Test
  public void specificParameters() {
    List<String> listMock = mock(List.class);
    when(listMock.get(0)).thenReturn("SomeString");
    assertEquals("SomeString", listMock.get(0));
    assertEquals(null, listMock.get(1));
  }

  @Test
  public void genericParameters() {
    List<String> listMock = mock(List.class);
    when(listMock.get(anyInt())).thenReturn("SomeOtherString");
    assertEquals("SomeOtherString", listMock.get(0));
    assertEquals("SomeOtherString", listMock.get(1));
  }
}
