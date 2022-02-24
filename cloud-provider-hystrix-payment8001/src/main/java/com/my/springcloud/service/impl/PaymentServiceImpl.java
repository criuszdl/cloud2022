package com.my.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.my.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    //=========服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    @Override
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
