package com.irilind.macro.foods;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/food")
public class FoodController {
    FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }


    @PostMapping
    public ResponseEntity<String> createFoodApi(@RequestBody Food food){
        Food service = foodService.createFood(food);
        return ResponseEntity.ok("Food created");
    }

    @GetMapping("/startingWith")
    public List<Food> getAllFoodStartingWith(@RequestParam("startingChar") String startingChar){
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "value"));
        return foodService.getAllFoodStartingWith(startingChar);
    }

}
