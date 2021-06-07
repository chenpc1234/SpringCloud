package com.chen.cloud.alibaba.controller;

import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/7/06/07  14:28
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    public static HashMap<String,Payment> map=new HashMap();
    static {
        map.put("1",new Payment(1L,"no1"));
        map.put("2",new Payment(2L,"no2"));
        map.put("3",new Payment(3L,"no3"));
    }
    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") String id){
        System.out.println(id);
        Payment payment = map.get(id);
        CommonResult<Payment> commonResult =new CommonResult<Payment>(200,"port:\t"+serverPort,payment);
        return commonResult;
    }
}
