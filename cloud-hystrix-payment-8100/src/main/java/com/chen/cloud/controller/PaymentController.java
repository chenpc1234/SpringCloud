package com.chen.cloud.controller;

import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/28/04/28  17:54
 */
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/seeOK/{id}")
    private CommonResult seeOk(@PathVariable("id") Long id){
        String s = paymentService.seeOk(id);
        return new CommonResult(200, "seeOK", s);
    }
    @GetMapping("/seeOK/timeout/{id}")
    private CommonResult seeOkTimeOut(@PathVariable("id") Long id){
        String s = paymentService.seeOkTimeOut(id);
        return new CommonResult(200, "seeOKTimeOut", s);
    }
}
