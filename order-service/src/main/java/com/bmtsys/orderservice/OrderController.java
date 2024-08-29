package com.bmtsys.orderservice;

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
    public String getOrderById(@PathVariable Long orderId) {

        String user = userServiceClient.getUserById(1L);

        return "Order ID: " + orderId + ", User: " + user;
    }
}
