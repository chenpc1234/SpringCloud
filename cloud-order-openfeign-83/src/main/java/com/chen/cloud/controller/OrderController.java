package com.chen.cloud.controller;

import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import com.chen.cloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/20/04/20  16:02
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private IPaymentService paymentService;

    @GetMapping("/consumer/qryPayment/{id}")
    public  CommonResult<Payment> query(@PathVariable("id") Long id){
        return paymentService.queryPayment(id);
    }
}
