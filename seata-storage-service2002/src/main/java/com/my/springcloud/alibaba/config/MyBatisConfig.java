package com.my.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZDL
 * @create 2022-03-18 20:23
 */
@Configuration
@MapperScan({"com.my.springcloud.alibaba.dao"})
public class MyBatisConfig {
}
