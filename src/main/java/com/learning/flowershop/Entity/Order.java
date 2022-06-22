package com.learning.flowershop.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate orderCreateDate;
    private LocalDate orderCompleteDate;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany (cascade = CascadeType.ALL)
    private Set<Flower> flower;
    private Integer price;

    public Order() {
    }

    public Order(Long id, LocalDate orderCreateDate, LocalDate orderCompleteDate, User user, Set<Flower> flower) {
        this.id = id;
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

    public LocalDate getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(LocalDate orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public LocalDate getOrderCompleteDate() {
        return orderCompleteDate;
    }

    public void setOrderCompleteDate(LocalDate orderCompleteDate) {
        this.orderCompleteDate = orderCompleteDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Flower> getFlower() {
        return flower;
    }

    public void setFlower(Set<Flower> flower) {
        this.flower = flower;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}