package com.chen.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author chenpc
 * @version 1.0
 * @since 2021/5/3/05/03  23:09
 */
//@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator myRouteLocator(RouteLocatorBuilder locatorBuilder){
        RouteLocatorBuilder.Builder routes = locatorBuilder.routes();
        routes.route("myRoute",r ->r.path("/consumer/see/**").uri("http://localhost:88/consumer/see/**") ).build();
        return routes.build();
    }

}
