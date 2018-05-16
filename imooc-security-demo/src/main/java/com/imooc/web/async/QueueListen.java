package com.imooc.web.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 * Created by wbcaoa on 2018/5/16.
 */
@Component
public class QueueListen implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(() ->{
            while (true) {

                if (StringUtils.isNotBlank(mockQueue.getCompleterOrder())) {

                    String orderNumber = mockQueue.getCompleterOrder();

                    logger.info("返回订单处理结果: " + orderNumber);

                    deferredResultHolder.getMap().get(orderNumber).setResult("place order success!");

                    mockQueue.setCompleterOrder(null);

                } else {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }
}
