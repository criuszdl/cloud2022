package com.my.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义负载均衡路由规则类
 * @author ZDL
 * @create 2022-02-22 10:58
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myIRule(){
        return new RandomRule();
    }

}
