package com.learning.flowershop.Controllers;

import com.learning.flowershop.Entity.Flower;
import com.learning.flowershop.Services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flowers")
public class FlowerController {
    private final FlowerService flowerService;

    @Autowired
    public FlowerController (FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping("/getAllFlowers")
    protected List<Flower> getAllFlowers() {
        return flowerService.getAllFlowers();
    }

    @PostMapping("/save")
    protected void save (@RequestBody Flower flower) {
        flowerService.saveFlower(flower);
    }
}