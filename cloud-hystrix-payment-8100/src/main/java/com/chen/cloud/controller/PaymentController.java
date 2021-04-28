package com.chen.cloud.controller;

import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/28/04/28  17:54
 */
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/qryPayment/{id}")
    private CommonResult queryPayment(@PathVariable("id") Long id){
        paymentService.seeOk(id);
        return null;
    }
    @GetMapping("/qryPayment/timeout/{id}")
    private CommonResult queryOutPayment(@PathVariable("id") Long id) throws InterruptedException {
        paymentService.seeOkTimeOut(id);
        return null;
    }
}
