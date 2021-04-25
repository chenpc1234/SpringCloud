package com.chen.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/19/04/19  15:05
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.chen.cloud.dao")
public class PaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class, args);
    }
}
