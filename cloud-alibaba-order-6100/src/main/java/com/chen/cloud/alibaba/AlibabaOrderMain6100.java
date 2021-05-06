package com.chen.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/6/05/06  14:45
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaOrderMain6100 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaOrderMain6100.class, args);
    }
}
