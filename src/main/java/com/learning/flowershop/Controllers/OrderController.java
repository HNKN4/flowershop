package com.learning.flowershop.Controllers;

import com.learning.flowershop.Entity.Order;
import com.learning.flowershop.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAllOrders")
    protected List<Order> getAllOrdersByUser(@Param("userId") Long userId) {
        return orderService.getAllOrdersByUserId(userId);
    }

    @PostMapping("/save")
    protected void save(@RequestBody Order order) {
        orderService.saveOrder(order);
    }
}