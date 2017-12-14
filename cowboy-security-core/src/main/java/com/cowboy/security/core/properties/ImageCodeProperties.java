package com.cowboy.security.core.properties;
/**
 * 图形代码配置类
 *
 * @author huxu
 * @create 2017-12-14 16:22
 **/

public class ImageCodeProperties extends SmsCodeProperties {

    public ImageCodeProperties() {
        setLength(4);
    }

    private int width = 67;
    private int height = 23;

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

}
