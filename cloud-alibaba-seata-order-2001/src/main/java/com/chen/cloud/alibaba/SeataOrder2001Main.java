package com.chen.cloud.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/8/05/08  15:23
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.chen.cloud.alibaba.dao")
public class SeataOrder2001Main {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrder2001Main.class, args);
    }
}
