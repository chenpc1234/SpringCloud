package com.chen.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/5/05/05  22:26
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitMQReceiveMain8891 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMQReceiveMain8891.class, args);
    }
}
