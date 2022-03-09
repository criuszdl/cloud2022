package com.my.springcloud.controller;

import com.my.springcloud.entities.CommonResult;
import com.my.springcloud.entities.Payment;
import com.my.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ZDL
 * @create 2022-02-16 23:11
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("********插入的结果为：" + result);
        if (result > 0 ){
            return new CommonResult(200,"插入数据库成功,serverport:" + serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败,serverport:" + serverPort,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("********111111查询的结果为：" + payment);
        if (payment != null){
            return new CommonResult(200,"查询成功,serverPort:" + serverPort,payment);
        }else{
            return new CommonResult(444,"查询失败，ID为" + id + "serverPort:" + serverPort,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object getDiscoveryClient(){
        List<String> services = discoveryClient.getServices();
        services.stream().forEach(item -> log.info("******item" + item));

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(item ->
                log.info(item.getInstanceId() + "\t" + item.getHost() + "\t" + item.getPort() + "\t" + item.getUri()));
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi,i`am paymentzipkin server fall back.welcome to zdl";
    }

}
