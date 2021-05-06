package com.chen.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/6/05/06  14:37
 */
@RestController
@RefreshScope
public class PaymentController {
    @Value("${config.paymentValue}")
    private String paymentValue;

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return " Payment 6002 Hello Nacos Discovery " +paymentValue+ string;
    }
}
