package com.marto.learn_spring_aop.aop_example.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

  @Pointcut("execution(* com.marto.learn_spring_aop.aop_example.*.*.*(..))")
  public void businessAndDataPackageConfig() {}

  @Pointcut("execution(* com.marto.learn_spring_aop.aop_example.business.*.*(..))")
  public void businessPackageConfig() {}

  @Pointcut("execution(* com.marto.learn_spring_aop.aop_example.data.*.*(..))")
  public void dataPackageConfig() {}

  @Pointcut("bean(*Service*)")
  public void allPackageConfigUsingBean() {}
}
