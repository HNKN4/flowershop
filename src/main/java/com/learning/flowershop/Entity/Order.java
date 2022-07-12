package com.learning.flowershop.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderCreateDate;
    private LocalDateTime orderCompleteDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToMany
    private List<Flower> flower;
    private Integer price;

    public Order() {
    }

    public Order(LocalDateTime orderCreateDate, LocalDateTime orderCompleteDate, User user, List<Flower> flower) {
        this.orderCreateDate = orderCreateDate;
        this.orderCompleteDate = orderCompleteDate;
        this.user = user;
        this.flower = flower;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(LocalDateTime orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public LocalDateTime getOrderCompleteDate() {
        return orderCompleteDate;
    }

    public void setOrderCompleteDate(LocalDateTime orderCompleteDate) {
        this.orderCompleteDate = orderCompleteDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Flower> getFlower() {
        return flower;
    }

    public void setFlower(List<Flower> flower) {
        this.flower = flower;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}