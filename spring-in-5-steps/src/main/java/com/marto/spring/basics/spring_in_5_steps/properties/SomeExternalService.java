package com.marto.spring.basics.spring_in_5_steps.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SomeExternalService {

  // from property file: app.properties -> external.service.url
  @Value("${external.service.url}")
  private String url;

  public String returnServiceUrl() {
    return url;
  }
}
