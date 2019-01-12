package com.connext.springdatajpa.util;


import com.connext.springdatajpa.annotation.AopAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class FirstAspect {

    @Pointcut("@annotation(com.connext.springdatajpa.annotation.AopAnnotation)")
    public void cutMethod() {
    }

    /*@Pointcut("within(com.connext.springboot..MessageController.*)")
    public void cutControllerMethod(){
    }
*/

    @Before(value="@annotation(aopAnnotation)")
    public void beforeLogin(JoinPoint joinPoint, AopAnnotation aopAnnotation){
        log.info("[before] module name:{}, method name:{}，method param:{}", aopAnnotation.value(), joinPoint.getSignature().getName(),Arrays.toString(joinPoint.getArgs()));
    }

}
