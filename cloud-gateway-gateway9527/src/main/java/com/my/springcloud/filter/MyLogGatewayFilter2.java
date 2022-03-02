package com.my.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author ZDL
 * @create 2022-03-02 21:53
 */
@Component
@Slf4j
public class MyLogGatewayFilter2 implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("come in global filter2: {}", new Date());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
