package com.chen.cloud.service;

import org.springframework.stereotype.Service;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/28/04/28  17:49
 */
@Service
public class PaymentService {

    public String seeOk(Long integer){
        return "OK"+integer;
    }
    public String seeOkTimeOut(Long integer) throws InterruptedException {
        Thread.sleep(3000);
        return "休息3秒---OK"+integer;
    }
}
