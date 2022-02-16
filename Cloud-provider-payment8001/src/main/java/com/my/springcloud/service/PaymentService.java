package com.my.springcloud.service;

import com.my.springcloud.entities.Payment;

/**
 * @author ZDL
 * @create 2022-02-16 23:04
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);

}
