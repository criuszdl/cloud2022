package com.my.springCloud.controller;

import com.my.springCloud.lb.LoadBalancer;
import com.my.springcloud.entities.CommonResult;
import com.my.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author ZDL
 * @create 2022-02-17 15:05
 */
@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL="http://localhost:8001";

    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
         log.info("consumerOrder80 发出请求创建一个订单的请求");
         return  restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("consumerOrder80 发出根据id查询订单的请求");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/"+ id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/entity/{id}")
    public CommonResult<Payment> getPaymentEntity(@PathVariable("id") Long id){
        log.info("consumerOrder80 发出根据id查询订单的请求");
        return restTemplate.getForEntity(PAYMENT_URL + "/payment/get/"+ id,CommonResult.class).getBody();
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0){
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

}
