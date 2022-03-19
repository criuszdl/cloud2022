package com.my.springcloud.alibaba.service;

/**
 * @author ZDL
 * @create 2022-03-18 21:14
 */
public interface StorageService {

    /** 减少库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);

}
