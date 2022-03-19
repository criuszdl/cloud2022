package com.my.springcloud.alibaba.service;

import com.my.springcloud.alibaba.domain.Order;

/**
 * @author ZDL
 * @create 2022-03-18 17:11
 */
public interface OrderService {


    /**
     * 创建订单接口
     * @param order 订单
     */
    void create(Order order);

}
