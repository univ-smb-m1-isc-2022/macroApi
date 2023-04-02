package com.irilind.macro.menuFood;

import com.irilind.macro.foods.Food;
import com.irilind.macro.menu.Menu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuFoodService {

    MenuFoodRepository repository;
    public MenuFoodService(MenuFoodRepository repository) {
        this.repository = repository;
    }

    public List<MenuFood> getAllMenuFood() {
        return repository.findAll();
    }

    public List<MenuFood> getAllByMenuId(Long menuId) {
        return repository.findAllByMenuId(menuId);
    }

    public MenuFood createMenuFood(MenuFood menuFood) {
        return repository.save(menuFood);
    }

    public MenuFood deleteMenuFoodWithId(Integer id) {
        MenuFood menuFood = repository.findById(id).get();
        repository.delete(menuFood);
        return menuFood;
    }

}
