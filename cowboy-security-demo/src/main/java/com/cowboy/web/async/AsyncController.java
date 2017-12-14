package com.cowboy.web.async;/**
 * Created by HUXU on 2017/12/13.
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * 多线程之异步处理
 *
 * @author huxu
 * @create 2017-12-13 15:10
 **/
@Slf4j
@RestController
@Api(value = "测试接口", description = "异步请求接口")
public class AsyncController {

    @Autowired
    private CowboyQueue cowboyQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @GetMapping("/order")
    @ApiOperation(value = "DeferredResult异步请求")
    public DeferredResult<String> order() throws Exception {
        log.info("主线程开始");

        String orderNumber = RandomStringUtils.randomNumeric(8);    //随机生成8位随机数
        cowboyQueue.setPlaceOrder(orderNumber);      //放到队列中

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, result);

        return result;
    }

    @GetMapping("/order1")
    @ApiOperation(value = "Callable异步请求")
    public Callable<String> orders() throws Exception{
        log.info("主线程开始");
        Callable<String> result = new Callable<String>() {
			@Override
			public String call() throws Exception {
				log.info("副线程开始");
				Thread.sleep(1000);
                log.info("副线程返回");
				return "success";
			}
		};
        log.info("主线程返回");
        return result;
    }


}
