package com.chen.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/28/04/28  17:46
 */
@SpringBootApplication
@EnableEurekaClient
public class HystrixPayment8100 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPayment8100.class, args);
    }
}
