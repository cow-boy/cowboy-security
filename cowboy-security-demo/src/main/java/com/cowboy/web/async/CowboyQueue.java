package com.cowboy.web.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 消息对象
 *
 * @author huxu
 * @create 2017-12-13 15:30
 **/
@Slf4j
@Component
public class CowboyQueue {

    /**
     * 下单消息
     */
    private String placeOrder;

    /**
     * 订单完成消息
     */
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) {

        new Thread(() -> {
            log.info("接收到下单请求:"+placeOrder);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.placeOrder = placeOrder;
            log.info("下单请求完成："+placeOrder);
        }).start();

    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
