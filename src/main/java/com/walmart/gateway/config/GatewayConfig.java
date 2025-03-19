package com.walmart.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product_service", r -> r.path("/api/products/**")
                        .filters(f -> f.requestRateLimiter(c -> {
                                    c.setRateLimiter(new RedisRateLimiter(5, 10));
                                })
                                .tokenRelay())
                        .uri("http://localhost:8081"))
                .build();
    }

}

