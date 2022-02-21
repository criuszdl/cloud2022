package com.my.spirngcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ZDL
 * @create 2022-02-21 14:32
 */
@SpringBootApplication
/**
 * 该注解用于向consul或者zookeeper作为注册中心注册服务
 */
@EnableDiscoveryClient
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }

}
