package com.chen.cloud.alibaba.controller;

import com.chen.cloud.alibaba.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/6/05/06  14:45
 */
@RestController
public class OrderController {
    @Autowired
    private IPaymentService paymentService;
    @GetMapping("/test")
    public String test() {
        System.out.println("OK!!!!!!!!");
        return paymentService.echo();
    }
}
