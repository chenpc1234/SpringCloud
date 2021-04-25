package com.chen.cloud.service.impl;

import com.chen.cloud.dao.PaymentDao;
import com.chen.cloud.entities.Payment;
import com.chen.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/20/04/20  09:17
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Payment queryPayment(Long id) {
        return paymentDao.queryPayment(id);
    }

    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }
}
