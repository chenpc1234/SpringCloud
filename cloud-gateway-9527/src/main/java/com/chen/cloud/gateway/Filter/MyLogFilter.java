package com.chen.cloud.gateway.Filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * 自定义gateway的过滤器
 * @author chenpc
 * @version 1.0
 * @since 2021/5/4/05/04  00:16
 */
@Component
@Slf4j
public class MyLogFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("-----MyLogFilter start--------"+new Date());
        //得到请求参数的第一个name 参数的值
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        if (!"chen".equals(name)){
            log.info("name 不是chen 不允许路由");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
