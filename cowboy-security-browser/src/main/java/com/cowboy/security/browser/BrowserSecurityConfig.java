package com.cowboy.security.browser;

import com.cowboy.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 用户授权
 *
 * @author huxu
 * @create 2017-12-13 17:52
 **/
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 配置密码加密信息
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();     //如果自己用md5加密写这
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/cowboy-signIn.html")   //指定登录页面
                .loginProcessingUrl("/authentication/form")    //表单登录的请求
          //http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require",
                        securityProperties.getBrowser().getLoginPage()).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable();    //跨站防护
    }
}
