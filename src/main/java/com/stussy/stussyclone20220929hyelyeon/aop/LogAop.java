package com.stussy.stussyclone20220929hyelyeon.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAop {

    @Pointcut("@annotation(com.stussy.stussyclone20220929hyelyeon.aop.annotation.LogAspect)")
    private void annotationPointCut() {}

//    @Pointcut("execution(* com.stussy.stussyclone20220929hyelyeon.controller.api.*.*(..))")
//    private void executionPointCut() {}

//    @Around("executionPointCut() || annotationPointCut()")
    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        //[ 로그찍는거
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        String[] argNames = codeSignature.getParameterNames();

        StringBuilder argNameString = new StringBuilder();
        StringBuilder argDataString = new StringBuilder();

        for(int i = 0; i < args.length; i++) {
            argNameString.append(argNames[i]);
            argDataString.append(args[i].toString());

            if(i < args.length - 1) {
                argNameString.append(", ");
                argDataString.append(", ");
            }
        }
        log.info("Method Call -- {}.{}({}) >> {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                argNameString.toString(),
                argDataString.toString());

        Object result = joinPoint.proceed();

        log.info("Method Return -- {}.{}({}) >> {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                argNameString.toString(),
                result);//로그찍기 ]

//        log.info("리턴 데이터 >> {}", result);

        return result;
    }
}
