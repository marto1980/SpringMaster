package com.marto.learn_spring_aop.aop_example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
  private Logger logger = LoggerFactory.getLogger(getClass());

  @Before(
      "com.marto.learn_spring_aop.aop_example.aspects.CommonPointcutConfig.allPackageConfigUsingBean()") // Pointcut: When to
  // intercept?
  public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
    logger.info(
        "Before Aspect - {} is called with arguments: {}",
        joinPoint,
        joinPoint.getArgs()); // Advice: What to execute on interception?
  }

  @After(
      "com.marto.learn_spring_aop.aop_example.aspects.CommonPointcutConfig.businessPackageConfig()") // Pointcut: When?
  public void logMethodCallAfterExecution(JoinPoint joinPoint) {
    logger.info("After Aspect - {} has executed", joinPoint); // Advice: What?
  }

  @AfterThrowing(
      pointcut =
          "com.marto.learn_spring_aop.aop_example.aspects.CommonPointcutConfig.businessAndDataPackageConfig()",
      throwing = "exception") // Pointcut: When?
  public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
    logger.info(
        "AfterThrowing Aspect - {} has thrown an exception {}",
        joinPoint,
        exception); // Advice: What?
  }

  @AfterReturning(
      pointcut =
          "com.marto.learn_spring_aop.aop_example.aspects.CommonPointcutConfig.dataPackageConfig()",
      returning = "resultValue") // Pointcut: When?
  public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
    logger.info(
        "AfterReturning Aspect - {} has returned {}", joinPoint, resultValue); // Advice: What?
  }
}
