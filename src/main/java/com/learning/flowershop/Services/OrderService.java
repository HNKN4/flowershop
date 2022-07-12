package com.learning.flowershop.Services;

import com.learning.flowershop.Entity.Flower;
import com.learning.flowershop.Entity.Order;
import com.learning.flowershop.Repositories.FlowerRepository;
import com.learning.flowershop.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final FlowerRepository flowerRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, FlowerRepository flowerRepository) {
        this.orderRepository = orderRepository;
        this.flowerRepository = flowerRepository;
    }

    public List<Order> getAllOrdersByUserId(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public void saveOrder(Order order) {
        List<Flower> flowerList = order.getFlower();
        int sum = 0;
        for (Flower flower:flowerList) {
            flower = flowerRepository.getById(flower.getId());
            sum += flower.getPrice();
        }
        order.setPrice(sum);
        LocalDateTime now = LocalDateTime.now();
        order.setOrderCreateDate(now);
        orderRepository.save(order);
    }
}