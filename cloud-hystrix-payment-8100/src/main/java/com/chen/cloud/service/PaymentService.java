package com.chen.cloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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
    public String seeOkTimeOut(Long integer) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "休息5秒---OK"+integer;
    }
}
