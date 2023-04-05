package com.irilind.macro.menuFood;

import com.irilind.macro.foods.Food;
import com.irilind.macro.menu.Menu;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/menu_food")
public class MenuFoodController {

    MenuFoodService menuFoodService;

    public MenuFoodController(MenuFoodService menuFoodService) {
        this.menuFoodService = menuFoodService;
    }

    @GetMapping
    public List<MenuFood> getAllMenuFood(){
        return menuFoodService.getAllMenuFood();
    }

    @GetMapping("/menu/{menuId}")
    public List<MenuFood> getAllByMenuId(@PathVariable Integer menuId){
        return menuFoodService.getAllByMenuId(menuId);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createMenuFoodApi(@RequestBody MenuFood menuFood){
        MenuFood service = menuFoodService.createMenuFood(menuFood);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/menu/{id}")
    public ResponseEntity<Map<String, Object>> deleteMenuFoodWithId(@PathVariable Integer id){
        MenuFood menuFood = menuFoodService.deleteMenuFoodWithId(id);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/recommend/{chosenFoodId}")
    public List<Integer> recommendFoods(@PathVariable Integer chosenFoodId) {
        return menuFoodService.recommendFoods(chosenFoodId);
    }
}
