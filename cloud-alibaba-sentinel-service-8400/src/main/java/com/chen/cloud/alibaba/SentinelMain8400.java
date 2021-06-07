package com.chen.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/3/06/03  17:25
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SentinelMain8400 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain8400.class, args);
    }
}
