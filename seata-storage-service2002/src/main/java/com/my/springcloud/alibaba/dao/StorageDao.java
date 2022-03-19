package com.my.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ZDL
 * @create 2022-03-18 21:07
 */
@Mapper
public interface StorageDao {
    /**
     *  减少 库存
     * @param productId 产品id
     * @param count  商品数量
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
