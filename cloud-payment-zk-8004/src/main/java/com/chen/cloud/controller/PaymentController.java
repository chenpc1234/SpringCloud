package com.chen.cloud.controller;

import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import com.chen.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/20/04/20  09:22
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    private CommonResult insertPayment(@RequestBody Payment payment){
        paymentService.insert(payment);
        return new CommonResult<Payment>(100,"success",payment);
    }

    @GetMapping("/qryPayment/{id}")
    private CommonResult queryPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.queryPayment(id);
        if (payment!=null){
            return new CommonResult(200, "success8002", payment);
        }else {
            return new CommonResult(500, "failed8002");
        }
    }
}
