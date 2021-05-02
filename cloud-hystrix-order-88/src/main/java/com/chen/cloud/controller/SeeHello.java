package com.chen.cloud.controller;

import com.chen.cloud.service.IPaymentService;
import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/29/04/29  23:41
 */
@RestController
public class SeeHello {

    @Autowired
    private IPaymentService paymentService;

    @GetMapping("/consumer/see/{id}")
    public CommonResult<Payment> see(@PathVariable("id") int id){
        return paymentService.seeOkTimeOut(id);
    }

    @GetMapping("/consumer/seeHello/{id}")
    @HystrixCommand(fallbackMethod = "seeError",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //断路器打开后再次请求的休眠期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),   //失败率
    })
    public CommonResult<Payment> seeHello(@PathVariable("id") int id){
        if (id<0){
            throw  new RuntimeException("不能是负数，抛出异常测试熔断");
        }
        return paymentService.seeOkTimeOut(id);
    }

    public CommonResult<Payment> seeError(@PathVariable("id") int id){
        return new CommonResult<>(500, "服务熔断  OPEN--seeError");
    }
}
