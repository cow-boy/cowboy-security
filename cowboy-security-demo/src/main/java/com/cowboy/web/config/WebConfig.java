package com.cowboy.web.config;

import com.cowboy.filter.TimeFilter;
import com.cowboy.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果是第三方过滤器，没有 @Component注解的时候，比如把TimeFilter类的@Component注解注释
 *
 * @author huxu
 * @create 2017-12-09 18:04
 **/
@Configuration    //配置类
public class WebConfig extends WebMvcConfigurerAdapter {         //extends WebMvcConfigurerAdapter是拦截器的时候添加并覆盖addInterceptors方法


    @Autowired
    private TimeInterceptor timeInterceptor;

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(timeInterceptor);
    }

    //异步请求拦截用
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        super.configureAsyncSupport(configurer);
    }

    //过滤器（第三方）
    @Bean
    public FilterRegistrationBean timeFilter() {

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);

        return registrationBean;

    }

}
