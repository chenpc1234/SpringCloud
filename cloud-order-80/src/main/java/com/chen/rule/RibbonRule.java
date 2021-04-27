package com.chen.rule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/27/04/27  11:06
 */
@Configuration
public class RibbonRule {
    @Bean
    public IRule getNewRule(){
        return new MyRule();
    }
}
