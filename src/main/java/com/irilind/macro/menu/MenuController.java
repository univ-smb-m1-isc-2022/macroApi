package com.irilind.macro.menu;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {

    MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createMenuApi(@RequestBody Menu menu){
        Menu service = menuService.createMenu(menu);
        Map<String, Object> response = new HashMap<>();
        response.put("id", menu.getId());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/startingWith")
    public List<Menu> getAllMenuStartingWith(@RequestParam("startingChar") String startingChar){
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "value"));
        return menuService.getAllMenuStartingWith(startingChar);
    }


}
