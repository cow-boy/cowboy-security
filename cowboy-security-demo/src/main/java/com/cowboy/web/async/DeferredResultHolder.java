package com.cowboy.web.async;/**
 * Created by HUXU on 2017/12/13.
 */

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * 线程之间传递值
 *
 * @author huxu
 * @create 2017-12-13 15:35
 **/
@Component
public class DeferredResultHolder {

    private Map<String, DeferredResult<String>> map = new HashMap<String, DeferredResult<String>>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }

}
