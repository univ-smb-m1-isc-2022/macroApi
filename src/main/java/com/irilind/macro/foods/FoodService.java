package com.irilind.macro.foods;


import com.irilind.macro.menu.Menu;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    FoodRepository repository;

    public FoodService(FoodRepository repository) {
        this.repository = repository;
    }

    public Food createFood(Food food) {
        return repository.save(food);
    }

    public List<Food> getAllFoodStartingWith(String startingChar) {
        PageRequest pageRequest = PageRequest.of(0, 10);
        return repository.findAllByNameStartingWith(startingChar, pageRequest);
    }


}
