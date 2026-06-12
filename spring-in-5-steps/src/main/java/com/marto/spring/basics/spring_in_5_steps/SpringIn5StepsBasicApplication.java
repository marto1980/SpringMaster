package com.marto.spring.basics.spring_in_5_steps;

import com.marto.spring.basics.spring_in_5_steps.basic.BinarySearchImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringIn5StepsBasicApplication {

  public static void main(String[] args) {
    // What are the beans?
    // What are the dependencies of a bean?
    // Where to search for beans? => No need as we are in the same package

    // BinarySearchImpl binarySearchImpl = new BinarySearchImpl(new QuickSortAlgorithm());
    // Application Context
    ConfigurableApplicationContext applicationContext =
        SpringApplication.run(SpringIn5StepsBasicApplication.class, args);
    BinarySearchImpl binarySearchImplBean = applicationContext.getBean(BinarySearchImpl.class);
    BinarySearchImpl binarySearchImplBean1 = applicationContext.getBean(BinarySearchImpl.class);
    System.out.println(binarySearchImplBean);
    System.out.println(binarySearchImplBean1);
    int result = binarySearchImplBean.binarySearch(new int[] {12, 4, 6}, 3);
    System.out.println(result);
  }
}
