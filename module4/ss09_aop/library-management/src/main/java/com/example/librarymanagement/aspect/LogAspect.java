package com.example.librarymanagement.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {
    private Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Pointcut("execution(* com.example.librarymanagement.service.RentServiceImpl.*(..))")
    public void rentService(){
    }

    @After("rentService()")
    public void writeLog(JoinPoint point){
        String methodName = point.getSignature().getName();
        logger.info("After calling method "+methodName);
    }
}
