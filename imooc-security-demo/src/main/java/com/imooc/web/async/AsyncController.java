package com.imooc.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * Created by wbcaoa on 2018/5/16.
 */
@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired private MockQueue mockQueue;

    @Autowired private DeferredResultHolder deferredResultHolder;

  /*  @GetMapping("/order")
    public Callable<String> order(){
        logger.info("订单主线程开始!");

        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                logger.info("订单副线程处理开始!");
                Thread.sleep(1000);
                logger.info("订单副线程处理结束!");
                return "success!";
            }
        };

        logger.info("订单主线程结束!");
        return result;
    }*/

    @GetMapping("/order")
    public DeferredResult<String> order() throws Exception {
        logger.info("订单主线程开始!");

        String orderNumber = new RandomStringUtils().randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber,result);
        logger.info("订单主线程结束!");
        return result;
    }

}
