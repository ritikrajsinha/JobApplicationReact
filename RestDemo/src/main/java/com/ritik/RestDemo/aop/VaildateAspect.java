package com.ritik.RestDemo.aop;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class VaildateAspect {
    private static final Logger LOGGER= LoggerFactory.getLogger(PerformaceMonitorAspect.class);

    @Around("execution(* com.ritik.RestDemo.service.JobService.getJobById(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp,int postId) throws Throwable {
      if(postId<0)
      {
          LOGGER.info("Post Id is updating");
          postId=-postId;
          LOGGER.info("updated one "+postId);
      }
      Object obj1=jp.proceed(new Object[]{postId});



        return obj1;
    }
}
