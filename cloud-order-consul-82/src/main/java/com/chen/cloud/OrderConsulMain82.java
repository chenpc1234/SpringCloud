package com.chen.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/20/04/20  14:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain82 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain82.class,args);
    }
}
