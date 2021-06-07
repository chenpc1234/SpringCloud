package com.chen.cloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chen.cloud.alibaba.service.IPaymentService;
import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/3/06/03  17:26
 */
@RestController
public class TestController {
    @Autowired
    public RestTemplate restTemplate;
    @Autowired
    public IPaymentService paymentService;


    @GetMapping("/test")
    @SentinelResource(value = "test",
            blockHandler = "blockHandler",
            fallback = "fallbackHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> test(String id){
        CommonResult<Payment> result = restTemplate.getForObject("http://alibaba-cloud-sentinel-service-producer" + "/paymentSQL/" + id, CommonResult.class);
        if ("4".equals(id)) {
            throw  new IllegalArgumentException("非法参数异常");
        }else if ("5".equals(id)){
            throw new NullPointerException("空指针");
        }
        return result;
    }

    @GetMapping("/test2")
    @SentinelResource(value = "test2")
    public CommonResult<Payment> test2(String id){
        CommonResult<Payment> result = paymentService.paymentSQL(id);
        if ("4".equals(id)) {
            throw  new IllegalArgumentException("非法参数异常");
        }else if ("5".equals(id)){
            throw new NullPointerException("空指针");
        }
        return result;
    }

    public CommonResult<Payment> fallbackHandler(String id,Throwable throwable){
        return new CommonResult<>(200, "fallbackHandler \t id:\t"+id+"\t"+throwable.getMessage());
    }
    public CommonResult<Payment> blockHandler(String id, BlockException e){
        return new CommonResult<>(200, "blockHandler  \t id:\t"+id+"\t"+e.getMessage());
    }
}
