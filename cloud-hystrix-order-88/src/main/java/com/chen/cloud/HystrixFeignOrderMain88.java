package com.chen.cloud;

import com.netflix.hystrix.HystrixMetrics;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/20/04/20  14:51
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class HystrixFeignOrderMain88 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignOrderMain88.class,args);
    }

    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet =new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean =new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
