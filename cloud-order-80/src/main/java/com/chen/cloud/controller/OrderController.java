package com.chen.cloud.controller;

import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/20/04/20  16:02
 */
@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_URL="http://localhost:8001";


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/qryPayment/{id}")
    public  CommonResult<Payment> query(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/qryPayment/"+id, CommonResult.class);
    }

}
