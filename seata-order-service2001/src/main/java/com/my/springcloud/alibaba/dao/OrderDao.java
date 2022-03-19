package com.my.springcloud.alibaba.dao;

import com.my.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ZDL
 * @create 2022-03-18 16:57
 */
@Mapper
public interface OrderDao {

    /**
     * 创建订单
     * @param order 订单
     */
    public void create(Order order);

    /**
     * 根据用户更新订单状态
     * @param userId 用户id
     * @param status 订单状态码
     */
    public void update(@Param("userId") Long userId, @Param("status")  Integer status);

}
