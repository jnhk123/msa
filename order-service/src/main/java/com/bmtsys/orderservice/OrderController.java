package com.bmtsys.orderservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private final UserServiceClient userServiceClient;

    @GetMapping("/{orderId}")
    @Retry(name = "USER-SERVICE", fallbackMethod = "fallBackGetOrderById")
    @CircuitBreaker(name = "USER-SERVICE", fallbackMethod = "fallBackGetOrderById")
    public String getOrderById(@PathVariable Long orderId) {
        String user = userServiceClient.getUserById(orderId);
        return "Order ID: " + orderId + ", User: " + user;
    }

    public String fallBackGetOrderById(Long orderId, Throwable throwable) {
        return "fallback";
    }

}
