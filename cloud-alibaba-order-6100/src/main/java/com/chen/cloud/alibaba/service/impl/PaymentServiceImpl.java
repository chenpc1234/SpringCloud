package com.chen.cloud.alibaba.service.impl;

import com.chen.cloud.alibaba.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/6/05/06  14:47
 */
@Service
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-payment-url}")
    private String paymentURL;


    @Override
    public String echo() {
        return restTemplate.getForObject(paymentURL+"/echo/ok",String.class);
    }

}
