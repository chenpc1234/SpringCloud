package com.chen.cloud.alibaba.service.impl;

import com.chen.cloud.alibaba.service.IPaymentService;
import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/7/06/07  17:06
 */
@Component
public class PaymentServiceImpl implements IPaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(String id) {
        return new CommonResult<>(200, "服务不可用");
    }
}
