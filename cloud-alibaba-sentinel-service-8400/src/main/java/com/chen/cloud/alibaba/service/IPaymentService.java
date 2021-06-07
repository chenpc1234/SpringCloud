package com.chen.cloud.alibaba.service;

import com.chen.cloud.alibaba.service.impl.PaymentServiceImpl;
import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/7/06/07  17:03
 */
@FeignClient(value = "alibaba-cloud-sentinel-service-producer",fallback = PaymentServiceImpl.class)
public interface IPaymentService {
    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") String id);
}
