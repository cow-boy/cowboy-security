package com.cowboy.security.browser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 自定义认证逻辑
 *
 * @author huxu
 * @create 2017-12-13 17:43
 **/
@Slf4j
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登录用户名："+username);

        //根据用户名查找用户信息
        //return new User(username, "123456", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));

        /**
         * 根据查找到用户信息判断用户是否被冻结,   第四个布尔值如果false是锁定的意思
         */
        String password = passwordEncoder.encode("123");
        log.info("数据库密码是："+password);
        return new User(username, password, true, true, true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
