package com.learning.flowershop.Services;

import com.learning.flowershop.Entity.Order;
import com.learning.flowershop.Entity.User;
import com.learning.flowershop.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrdersByUserId(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}