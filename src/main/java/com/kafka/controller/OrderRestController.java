package com.kafka.controller;

import com.kafka.entity.Order;
import com.kafka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public String createOrder(@RequestBody Order order){
        String response = orderService.addMsg(order);
        return response;
    }
}
