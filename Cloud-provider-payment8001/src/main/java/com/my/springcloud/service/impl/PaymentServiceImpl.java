package com.my.springcloud.service.impl;

import com.my.springcloud.dao.PaymentDao;
import com.my.springcloud.entities.Payment;
import com.my.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZDL
 * @create 2022-02-16 23:05
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        Payment paymentById = paymentDao.getPaymentById(id);
        System.out.println(paymentById.toString());
        return paymentById;
    }
}
