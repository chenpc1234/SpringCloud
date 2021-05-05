package com.chen.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/5/05/05  20:26
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitMQSendMain8890 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMQSendMain8890.class, args);
    }
}
