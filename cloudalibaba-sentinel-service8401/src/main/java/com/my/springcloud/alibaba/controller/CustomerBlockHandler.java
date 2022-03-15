package com.my.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.my.springcloud.entities.CommonResult;

/**
 * @author ZDL
 * @create 2022-03-15 18:02
 */
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息......CustomerBlockHandler");
    }
}
