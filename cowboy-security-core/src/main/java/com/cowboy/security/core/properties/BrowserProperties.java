package com.cowboy.security.core.properties;

/**
 * 浏览器配置类
 *
 * @author huxu
 * @create 2017-12-14 16:11
 **/
public class BrowserProperties {

    private SessionProperties session = new SessionProperties();

    /**
     * 默认登录页面
     */
    private String signUpUrl = "/cowboy-signUp.html";

    private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;

    private LoginResponseType loginType = LoginResponseType.JSON;

    /**
     * 默认记住我时间
     */
    private int rememberMeSeconds = 3600;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginResponseType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginResponseType loginType) {
        this.loginType = loginType;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }

    public SessionProperties getSession() {
        return session;
    }

    public void setSession(SessionProperties session) {
        this.session = session;
    }
    
}
