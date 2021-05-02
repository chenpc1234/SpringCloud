package com.chen.cloud.service;

import com.chen.cloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/27/04/27  16:42
 * FeignClient 指定调用的服务名称 ，默认调用的fallback service
 * @FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = PaymentService.class)
 *
 */
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = PaymentService.class)
@Component
public interface IPaymentService {
    /**
     * seeOk
     * @param id seeOk
     * @return seeOk
     */
    @GetMapping("/seeOK/{id}")
    public CommonResult seeOk(@PathVariable("id") int id);


    @GetMapping("/seeOK/timeout/{id}")
    public CommonResult seeOkTimeOut(@PathVariable("id") int id);


}
