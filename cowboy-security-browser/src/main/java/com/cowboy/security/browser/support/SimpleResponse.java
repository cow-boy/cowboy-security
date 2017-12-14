package com.cowboy.security.browser.support;

/**
 * 返回
 *
 * @author huxu
 * @create 2017-12-14 17:15
 **/

public class SimpleResponse {

    public SimpleResponse(Object content){
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

}
