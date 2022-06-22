package com.learning.flowershop.Repositories;

import com.learning.flowershop.Entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Long> {
    List<Flower> findAll();
}