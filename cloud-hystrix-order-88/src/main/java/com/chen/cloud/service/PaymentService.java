package com.chen.cloud.service;

import com.chen.cloud.entities.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/29/04/29  17:51
 */
@Component
public class PaymentService implements IPaymentService{
    @Override
    public CommonResult seeOk(int id) {
        return new CommonResult(500, "服务不可用", "FeignFallBack--->服务不可用") ;
    }

    @Override
    public CommonResult seeOkTimeOut(int id) {
        return new CommonResult(500, "服务不可用", "FeignFallBack--->服务不可用") ;
    }
}
