package com.irilind.macro.menuFood;

import com.irilind.macro.foods.Food;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuFoodService {

    MenuFoodRepository repository;
    public MenuFoodService(MenuFoodRepository repository) {
        this.repository = repository;
    }

    public MenuFood createMenuFood(MenuFood menuFood) {
        return repository.save(menuFood);
    }

    public List<MenuFood> getAllMenuFood() {
        return repository.findAll();
    }

    public List<MenuFood> getAllByMenuName(String menuName) {
        return repository.findAllByMenuName(menuName);
    }

}
