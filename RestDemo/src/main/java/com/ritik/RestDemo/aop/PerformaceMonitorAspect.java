package com.ritik.RestDemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformaceMonitorAspect {
    private static final Logger LOGGER= LoggerFactory.getLogger(PerformaceMonitorAspect.class);


    @Around("execution(* com.ritik.RestDemo.service.JobService.getAllJobs(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
        long start=System.currentTimeMillis();

        Object obj=jp.proceed();


        long end=System.currentTimeMillis();


        LOGGER.info("printing time"+jp.getSignature().getName()+" "+(end-start));

        return obj;

    }
}
