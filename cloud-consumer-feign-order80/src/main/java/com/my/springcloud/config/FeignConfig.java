package com.my.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZDL
 * @create 2022-02-23 11:16
 */
@Configuration
public class FeignConfig {

    /**
     * feignClient配置日志级别
     * @return
     */
    @Bean
    public Logger.Level feignLOggerLevel(){
        // 请求和响应的头信息,请求和响应的正文及元数据
        return Logger.Level.FULL;
    }

}
