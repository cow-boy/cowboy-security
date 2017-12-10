package com.cowboy.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 切片
 *
 * @author huxu
 * @create 2017-12-10 18:32
 **/
@Slf4j
@Component
@Aspect                 //切片注解
public class TimeAspect {

        //@After()    @Before()
        @Around("execution(* com.cowboy.web.controller.UserController.*(..))")       //切入点，拦截UserController所有参数和请求
        public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {       //增强

            log.info("*****************time aspect start");

            Object[] args = pjp.getArgs();    //方法的参数的数组
            for (Object arg : args) {
                log.info("*****************arg is "+arg);
            }

            long start = System.currentTimeMillis();

            Object object = pjp.proceed();     //被拦截的方法， 相当于chain.doFilter(request, response);

            log.info("*****************time aspect 耗时:"+ (System.currentTimeMillis() - start));

            log.info("*****************time aspect end");

            return object;
        }

}
