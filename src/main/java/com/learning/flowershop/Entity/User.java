package com.learning.flowershop.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private Integer money;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Order> orders;

    public User() {
    }

    public User(Long id, String login, Integer money, Set<Order> orders) {
        this.id = id;
        this.login = login;
        this.money = money;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}