package com.my.springcloud.service.impl;

import com.my.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ZDL
 * @create 2022-02-24 10:11
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfoOK(Integer id) {
        return "It's okay , I am alright. id = " + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    @Override
    public String paymentInfoTimeOut(Integer id) {
        //int age = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "可以正常访问，但耗时3秒钟。";
    }

    public String paymentInfoTimeOutHandler(Integer id) {
        return "服务降级成功：系统繁忙，请稍后再试！";
    }
}
