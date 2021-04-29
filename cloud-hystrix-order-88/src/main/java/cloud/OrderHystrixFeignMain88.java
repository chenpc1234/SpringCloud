package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/20/04/20  14:51
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
//@EnableCircuitBreaker
public class OrderHystrixFeignMain88 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixFeignMain88.class,args);
    }
}
