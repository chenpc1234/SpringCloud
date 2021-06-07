package com.chen.cloud.alibaba.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/6/3/06/03  17:17
 */
@Service
public class SeeHelloService {
    @Autowired
    private RestTemplate restTemplate;
    @SentinelResource("see")
    public String see(){
        return  restTemplate.getForObject("http://alibaba-cloud-sentinel-service-8400"+"/test",String.class);
    }
}
