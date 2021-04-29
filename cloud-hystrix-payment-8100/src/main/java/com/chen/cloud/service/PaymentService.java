package com.chen.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/28/04/28  17:49
 */
@Service
public class PaymentService {


    public String seeOk(int integer){
        return "OK"+integer;
    }

    /**
     * 服务降级 方法1（需要降级的method上单独配置 很傻逼）
     * 在处理Service的Method中添加@HystrixCommand
     *  1. 标注的方法出现异常 或者 超过指定的时间后 会调用fallbackMethod 指定的方法
     *  2. 服务降级方法，一般使用在服务调用者方  // 服务提供者方只作为学习使用
     *   假设服务端允许休息 5s  传入的值为休息时间。  那么输入01234都可以正常返回成功休息，大于5则不行
     *   另 ： 消费者 只允许休息 2s  那么2s后返回的数据 在消费者端可以进行服务降级
     * @param integer id
     * @return  返回值
     */
    @HystrixCommand(fallbackMethod = "seeOkTimeOut_handle",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String seeOkTimeOut(int integer) {
        System.out.println("8100 service seeOkTimeOut");
        try {
            TimeUnit.SECONDS.sleep(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "成功休息"+integer+"秒---";
    }
    public String seeOkTimeOut_handle(int integer) {
        return "服务端不允许休息"+integer+"秒---";
    }

}
