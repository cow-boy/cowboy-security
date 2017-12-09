package com.cowboy.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器   preHandle和postHandle两个方法处理，而过滤器只用doFilter一个方法处理
 *
 * @author huxu
 * @create 2017-12-09 18:12
 **/
@Slf4j
@Component
public class TimeInterceptor implements HandlerInterceptor {

    //handler拿不到传入的值，所以用切边了
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("===========preHandle");

        log.info("==========="+((HandlerMethod)handler).getBean().getClass().getName());
        log.info("==========="+((HandlerMethod)handler).getMethod().getName());

        request.setAttribute("startTime", System.currentTimeMillis());

        return true;    //false决定是否调用方法
    }

    //如果抛出异常就不会进来了
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("=========postHandle");
        Long start = (Long) request.getAttribute("startTime");
        log.info("=========postHandle time interceptor 耗时:"+ (System.currentTimeMillis() - start));
    }

    //无论是成功和失败都会进来
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        log.info("=========afterCompletion");
        Long start = (Long) request.getAttribute("startTime");
        log.info("=========afterCompletion time interceptor 耗时:"+ (System.currentTimeMillis() - start));
        log.info("=========ex is "+e);  //如果e为null，是我们写的自定义异常处理了
    }
}
