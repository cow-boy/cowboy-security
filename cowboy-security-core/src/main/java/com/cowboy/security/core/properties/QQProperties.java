package com.cowboy.security.core.properties;
import org.springframework.boot.autoconfigure.social.SocialProperties;
/**
 * QQ配置类
 *
 * @author huxu
 * @create 2017-12-14 16:26
 **/

public class QQProperties extends SocialProperties {

    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

}
