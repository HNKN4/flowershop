package com.learning.flowershop.Services;

import com.learning.flowershop.Entity.Flower;
import com.learning.flowershop.Repositories.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlowerService {
    private final FlowerRepository flowerRepository;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<Flower> getAllFlowers() {
        return flowerRepository.findAll();
    }

    public void saveFlower(Flower flower) {
        flowerRepository.save(flower);
    }
}