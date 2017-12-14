package com.cowboy.security.core;

import com.cowboy.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 核心配置类
 *
 * @author huxu
 * @create 2017-12-14 17:59
 **/

@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}