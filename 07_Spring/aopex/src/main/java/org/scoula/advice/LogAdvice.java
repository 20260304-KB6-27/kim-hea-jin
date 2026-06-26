package org.scoula.advice;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// Aspect: 공통 관심사(로깅)을 모아놓은 모듈
@Aspect
@Log4j2
@Component
public class LogAdvice {

  // Advice: Target에 적용시킬 동작들

  // Before Advice: 대상 메서드(Target) 실행 직전에 동작
  // execution: Target 지정
  // 형식: execution([반환타입] [클래스 풀네임].[메소드명])
  // 해당 타켓에 Before Advice 적용
  @Before(value = "execution(* org.scoula.sample.service.SampleService*.doAdd(String, String))" +
                  "&& args(str1, str2)", argNames = "str1, str2")
  public void logBeforeWithParam(String str1, String str2) {  // target의 인자 주입받음

    log.info("😽 Before Advice 동작");
    log.info("str1: {}", str1);
    log.info("str2: {}", str2);
  }

  // AfterThrowing Advice: 예외 발생 이후 동작
  // *(..): 해당 클래스의 모든 메서드, 파라미터 적용
  @AfterThrowing(value = "execution(* org.scoula.sample.service.SampleService*.*(..))"
          , throwing = "exception")
  public void AfterThrowingTest(Exception exception) {  // target의 인자 주입받음

    log.info("😽 AfterThrowing 동작");
    log.info("😽 exception: {}", exception.getMessage());
  }

  @Around(value = "execution(* org.scoula.sample.service.SampleService*.*(..))")
  public Object AroundTest(ProceedingJoinPoint pjp) {

    long start = System.currentTimeMillis();  // 시작 시간

    log.info("😽 Around 동작");
    log.info("Target: {}", pjp.getTarget());  // 현재 호출 대상

    Object result = null;
    try {
      result = pjp.proceed();  // 실제 Target 메소드 호출
    } catch (Throwable e) {
      e.printStackTrace();
    }

    long end = System.currentTimeMillis();  // 종료 시간

    log.info("📷 실제 소요시간: " + (end - start));

    return result;
  }

}
