package com.irilind.macro.foods;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    FoodRepository repository;

    public FoodService(FoodRepository repository) {
        this.repository = repository;
    }

    public Food createFood(Food food) {
        return repository.save(food);
    }

}
