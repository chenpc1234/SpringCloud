package com.chen.cloud.controller;

import com.chen.cloud.entities.Payment;
import com.chen.cloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/20/04/20  16:02
 */
@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_URL="http://cloud-payment-consul-service";

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/qryPayment/{id}")
    public  CommonResult<Payment> query(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/qryPayment/"+id, CommonResult.class);
    }

    @GetMapping("/test")
    private DiscoveryClient test(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("*******"+service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                System.out.println(instance.getServiceId() + instance.getInstanceId() + instance.getUri());
            }

        }

        return  discoveryClient;
    }

}
