package com.bmtsys.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/{orderId}")
    public String getOrderById(@PathVariable Long orderId) {
        String user = webClientBuilder.build()
                .get()
                .uri("http://user-service/users/1")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return "Order ID: " + orderId + ", User: " + user;
    }
}
