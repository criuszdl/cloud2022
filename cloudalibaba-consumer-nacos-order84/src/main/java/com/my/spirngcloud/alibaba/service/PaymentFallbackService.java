package com.my.spirngcloud.alibaba.service;

import com.my.springcloud.entities.CommonResult;
import com.my.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * 服务降级处理类
 * @author ZDL
 * @create 2022-03-15 20:08
 */

@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回,没有该流水信息",new Payment(id, "errorSerial......"));
    }
}
