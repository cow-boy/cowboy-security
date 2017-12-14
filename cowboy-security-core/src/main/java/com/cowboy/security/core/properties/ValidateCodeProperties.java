package com.cowboy.security.core.properties;

/**
 * 验证配置类
 *
 * @author huxu
 * @create 2017-12-14 16:21
 **/

public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }

    public SmsCodeProperties getSms() {
        return sms;
    }

    public void setSms(SmsCodeProperties sms) {
        this.sms = sms;
    }

}
