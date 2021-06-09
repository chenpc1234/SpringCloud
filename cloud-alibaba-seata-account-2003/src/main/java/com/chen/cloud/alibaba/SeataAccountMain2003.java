package com.chen.cloud.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/8/06/08  17:09
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.chen.cloud.alibaba.dao")
public class SeataAccountMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMain2003.class,args);
    }
}
