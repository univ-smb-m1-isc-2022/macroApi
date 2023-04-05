package com.irilind.macro.menuFood;

import com.irilind.macro.foods.Food;
import com.irilind.macro.menu.Menu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuFoodService {

    MenuFoodRepository repository;
    public MenuFoodService(MenuFoodRepository repository) {
        this.repository = repository;
    }

    public List<MenuFood> getAllMenuFood() {
        return repository.findAll();
    }

    public List<MenuFood> getAllByMenuId(Integer menuId) {
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

    public List<Integer> recommendFoods(Integer chosenFoodId) {
        List<MenuFood> menuFoods = repository.findAll();

        // count how many times each food appears with the chosen food
        Map<Integer, Integer> foodCounts = new HashMap<>();
        for (MenuFood menuFood : menuFoods) {
            if (menuFood.getFood().getId().equals(chosenFoodId)) {
                List<MenuFood> otherMenuFoods = getAllByMenuId(menuFood.getMenu().getId());
                for (MenuFood otherMenuFood : otherMenuFoods) {
                    if (!otherMenuFood.getFood().getId().equals(chosenFoodId)) {
                        foodCounts.put(otherMenuFood.getFood().getId(),
                                foodCounts.getOrDefault(otherMenuFood.getFood().getId(), 0) + 1);
                    }
                }
            }
        }

        // sort the foods by their counts and return the top recommendations
        List<Integer> recommendedFoodIds = new ArrayList<>(foodCounts.keySet());
        recommendedFoodIds.sort((f1, f2) -> foodCounts.get(f2).compareTo(foodCounts.get(f1)));
        return recommendedFoodIds.subList(0, Math.min(recommendedFoodIds.size(), 10));
    }

}
