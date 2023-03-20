package com.irilind.macro.foods;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/food")
public class FoodController {
    FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from my bedroom");
    }

    @PostMapping
    public ResponseEntity<String> createFoodApi(@RequestBody Food food){
        Food service = foodService.createFood(food);
        return ResponseEntity.ok("Food created");
    }
}
