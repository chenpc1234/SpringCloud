package com.chen.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/7/06/07  14:25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain8402 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain8402.class, args);
    }
}
