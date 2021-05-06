package com.chen.cloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/6/05/06  14:27
 */
@RestController
public class PaymentController {
    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Payment 6001 Hello Nacos Discovery " + string;
    }
}
