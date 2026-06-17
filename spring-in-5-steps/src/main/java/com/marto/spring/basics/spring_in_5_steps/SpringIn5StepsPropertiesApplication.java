package com.marto.spring.basics.spring_in_5_steps;

import com.marto.spring.basics.spring_in_5_steps.properties.SomeExternalService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
// app.properties
@PropertySource("classpath:app.properties")
public class SpringIn5StepsPropertiesApplication {

  public static void main(String[] args) {
    // What are the beans?
    // What are the dependencies of a bean?
    // Where to search for beans? => No need as we are in the same package

    // BinarySearchImpl binarySearchImpl = new BinarySearchImpl(new QuickSortAlgorithm());
    // Application Context
    try (ConfigurableApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(SpringIn5StepsPropertiesApplication.class)) {

      SomeExternalService service = applicationContext.getBean(SomeExternalService.class);
      System.out.println(service.returnServiceUrl());
    }
  }
}
