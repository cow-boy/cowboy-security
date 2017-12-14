package com.cowboy.web.async;/**
 * Created by HUXU on 2017/12/13.
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 队列的监听器
 *
 * @author huxu
 * @create 2017-12-13 15:42
 **/
@Slf4j
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private CowboyQueue cowboyQueue;   //模拟的队列

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {   //系统起来时就监听
        new Thread(() -> {
            while (true) {

                if (StringUtils.isNotBlank(cowboyQueue.getCompleteOrder())) {    //当模拟列队中有值的时候

                    String orderNumber = cowboyQueue.getCompleteOrder();
                    log.info("返回订单处理结果:"+orderNumber);
                    deferredResultHolder.getMap().get(orderNumber).setResult("place order success");   //最终返回的信息
                    cowboyQueue.setCompleteOrder(null);

                }else{
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }
}

