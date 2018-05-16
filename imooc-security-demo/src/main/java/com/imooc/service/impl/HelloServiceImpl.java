package com.imooc.service.impl;

import com.imooc.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by wbcaoa on 2018/5/15.
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void greeting(String name) {
        System.out.println("hello : " + name);
    }
}
