package com.irilind.macro.menuFood;

import com.irilind.macro.foods.Food;
import com.irilind.macro.menu.Menu;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/menu_food")
public class MenuFoodController {

    MenuFoodService menuFoodService;

    public MenuFoodController(MenuFoodService menuFoodService) {
        this.menuFoodService = menuFoodService;
    }
    @PostMapping
    public ResponseEntity<String> addFoodToMenu(@RequestBody MenuFood menuFood){
        MenuFood service = menuFoodService.createMenuFood(menuFood);
        return new ResponseEntity<>("Food added to menu", null, 200);
    }

    @GetMapping
    public List<MenuFood> getAllMenuFood(){
        return menuFoodService.getAllMenuFood();
    }

    @GetMapping("/menu/{menuName}")
    public List<MenuFood> getAllByMenuName(@PathVariable String menuName){
        return menuFoodService.getAllByMenuName(menuName);
    }


}
