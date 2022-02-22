package com.my.springCloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZDL
 * @create 2022-02-17 15:10
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
/*    @LoadBalanced*///手动负载均衡
    public RestTemplate getRestTemplate(){
            return new RestTemplate();
    }

}
