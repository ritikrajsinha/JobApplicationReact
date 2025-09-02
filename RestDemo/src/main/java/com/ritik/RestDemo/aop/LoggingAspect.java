package com.ritik.RestDemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.ritik.RestDemo.service.JobService.getAllJobs(..)) || execution(* com.ritik.RestDemo.service.JobService.getJobById(..))" )
    private void loggingMethod(JoinPoint jp)
    {
        LOGGER.info("Method called bhai "+jp.getSignature().getName());
    }
    @After("execution(* com.ritik.RestDemo.service.JobService.getAllJobs(..)) || execution(* com.ritik.RestDemo.service.JobService.getJobById(..))" )
    private void loggingExecution(JoinPoint jp)
    {
        LOGGER.info("Method Executed bhai "+jp.getSignature().getName());
    }
    @AfterThrowing("execution(* com.ritik.RestDemo.service.JobService.getAllJobs(..)) || execution(* com.ritik.RestDemo.service.JobService.getJobById(..))" )
    private void loggingException(JoinPoint jp)
    {
        LOGGER.info("Method Phat gaya bhai "+jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.ritik.RestDemo.service.JobService.getAllJobs(..)) || execution(* com.ritik.RestDemo.service.JobService.getJobById(..))" )
    private void loggingAfterReturning(JoinPoint jp)
    {
        LOGGER.info("Method success bhai "+jp.getSignature().getName());
    }
}
