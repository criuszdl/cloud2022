package com.my.springcloud.service.impl;

import com.my.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author ZDL
 * @create 2022-02-24 13:58
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return"-- PaymentFallbackService 统一处理接口中的降级 ok";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return"-- PaymentFallbackService 统一处理接口中的超时 timeout";
    }
}
