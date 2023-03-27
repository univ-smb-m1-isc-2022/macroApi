package com.irilind.macro.menuFood;

import org.springframework.stereotype.Service;

@Service
public class MenuFoodService {

    MenuFoodRepository repository;
    public MenuFoodService(MenuFoodRepository repository) {
        this.repository = repository;
    }

    public MenuFood createMenuFood(MenuFood menuFood) {
        return repository.save(menuFood);
    }

}
