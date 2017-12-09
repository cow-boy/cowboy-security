package com.cowboy.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器实现
 *
 * @author huxu
 * @create 2017-12-09 14:06
 *
 **/
@Slf4j
//@Component      //过滤器注解
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("---------------TimeFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("----------------TimeFilter doFilter start");
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);          //所有请求都会经过这个过滤器处理
        log.info("----------------time filter 耗时:"+ (System.currentTimeMillis() - start));
        log.info("----------------TimeFilter doFilter finish");
    }

    @Override
    public void destroy() {
        log.info("------------------TimeFilter destroy");
    }
}
