package com.chen.cloud.service;

import com.chen.cloud.entities.Payment;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/20/04/20  09:17
 */
public interface PaymentService {
    /**
     * 查询
     * @param id id
     * @return paymeat
     */
    public Payment queryPayment(Long id);

    /**
     * 插入
     * @param payment payment
     * @return paymnet
     */
    public int insert(Payment payment);
}
