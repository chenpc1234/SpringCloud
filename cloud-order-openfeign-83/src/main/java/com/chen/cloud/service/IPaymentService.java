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
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@Component
public interface IPaymentService {
    /**
     * chaxun
     * @param id id
     * @return CommonResult
     */
    @GetMapping("/qryPayment/{id}")
   public CommonResult queryPayment(@PathVariable("id") Long id);
}
