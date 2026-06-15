package com.marto.spring.basics.spring_in_5_steps;

import com.marto.spring.basics.spring_in_5_steps.basic.BinarySearchImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringIn5StepsBasicApplication {

  public static void main(String[] args) {
    // What are the beans?
    // What are the dependencies of a bean?
    // Where to search for beans? => No need as we are in the same package

    // BinarySearchImpl binarySearchImpl = new BinarySearchImpl(new QuickSortAlgorithm());
    // Application Context
    ConfigurableApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(SpringIn5StepsBasicApplication.class);
    BinarySearchImpl binarySearchImplBean = applicationContext.getBean(BinarySearchImpl.class);
    BinarySearchImpl binarySearchImplBean1 = applicationContext.getBean(BinarySearchImpl.class);
    System.out.println(binarySearchImplBean);
    System.out.println(binarySearchImplBean1);
    int result = binarySearchImplBean.binarySearch(new int[] {12, 4, 6}, 3);
    System.out.println(result);
    applicationContext.close();
  }
}
