/**
 *
 */
package com.cowboy.service.impl;

import com.cowboy.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author huxu
 */
@Service
public class HelloServiceImpl implements HelloService {

    /* (non-Javadoc)
     * @see com.imooc.service.HelloService#greeting(java.lang.String)
     */
    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello " + name;
    }

}
