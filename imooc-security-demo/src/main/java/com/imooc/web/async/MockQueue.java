package com.imooc.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by wbcaoa on 2018/5/16.
 */
@Component
public class MockQueue {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String placeOrder;

    private String completerOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(String placeOrder) throws Exception {
        new Thread(() -> {
            logger.info("接到下单请求!" + placeOrder);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.completerOrder = placeOrder;
            logger.info("下单请求处理完成!" + placeOrder);
        }).start();
    }

    public String getCompleterOrder() {
        return completerOrder;
    }

    public void setCompleterOrder(String completerOrder) {
        this.completerOrder = completerOrder;
    }
}
