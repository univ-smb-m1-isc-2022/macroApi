package com.irilind.macro.menuFood;

import com.irilind.macro.menu.Menu;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
