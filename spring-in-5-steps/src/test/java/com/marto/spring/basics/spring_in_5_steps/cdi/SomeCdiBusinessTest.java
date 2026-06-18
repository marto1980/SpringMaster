package com.marto.spring.basics.spring_in_5_steps.cdi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.marto.spring.basics.spring_in_5_steps.SpringIn5StepsBasicApplication;
import java.util.OptionalInt;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

@ExtendWith({MockitoExtension.class})
@ContextConfiguration(classes = SpringIn5StepsBasicApplication.class)
public class SomeCdiBusinessTest {

  @InjectMocks private SomeCdiBusiness business;

  @Mock private SomeCdiDao daoMock;

  @Test // This is now the org.junit.jupiter.api.Test annotation
  public void testBasicScenario() {
    when(daoMock.getData()).thenReturn(new int[] {2, 4});
    OptionalInt result = business.findGreatest();
    assertEquals(4, result.getAsInt());
  }

  @Test // This is now the org.junit.jupiter.api.Test annotation
  public void testEmptyArray() {
    when(daoMock.getData()).thenReturn(new int[] {});
    OptionalInt result = business.findGreatest();
    assertTrue(result.isEmpty());
  }

  @Test // This is now the org.junit.jupiter.api.Test annotation
  public void testEqualValuesArray() {
    when(daoMock.getData()).thenReturn(new int[] {2, 2});
    OptionalInt result = business.findGreatest();
    assertEquals(2, result.getAsInt());
  }
}
