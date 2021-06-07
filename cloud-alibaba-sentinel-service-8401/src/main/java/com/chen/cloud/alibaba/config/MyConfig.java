package com.chen.cloud.alibaba.config;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/3/06/03  17:29
 */
@Configuration
public class MyConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public FilterRegistrationBean sentinelFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new CommonFilter());
        registrationBean.addUrlPatterns("/*");
        // 入口资源关闭聚合
        registrationBean.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY, "false");
        registrationBean.setName("sentinelFilter");
        registrationBean.setOrder(1);

        return registrationBean;
    }
}
