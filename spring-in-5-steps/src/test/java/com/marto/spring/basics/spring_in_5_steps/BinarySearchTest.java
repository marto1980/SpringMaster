package com.marto.spring.basics.spring_in_5_steps;

import com.marto.spring.basics.spring_in_5_steps.basic.BinarySearchImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

// CHANGE 1: Use Jupiter instead of org.junit.Test
import org.junit.jupiter.api.Test;
// CHANGE 2: Use ExtendWith and SpringExtension instead of RunWith/SpringRunner
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) // Replaces @RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringIn5StepsBasicApplication.class)
public class BinarySearchTest {

  @Autowired private BinarySearchImpl binarySearchImpl;

  @Test // This is now the org.junit.jupiter.api.Test annotation
  public void testBasicScenario() {
    int result = binarySearchImpl.binarySearch(new int[] {}, 5);
    assertEquals(3, result);
  }
}
