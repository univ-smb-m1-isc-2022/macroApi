package com.irilind.macro.userMenu;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/user_menu")
public class UserMenuController {

    UserMenuService userMenuService;

    public UserMenuController(UserMenuService userMenuService) {
        this.userMenuService = userMenuService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createUserMenu(@RequestBody UserMenu userMenu) {
        UserMenu service = userMenuService.createUserMenu(userMenu);
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        return ResponseEntity.ok(response);
    }


    @GetMapping
    public List<UserMenu> getAllUserMenu() {
        return userMenuService.getAllUserMenu();
    }

    @GetMapping("/user/{userId}")
    public List<UserMenu> getAllUserMenuByUserId(@PathVariable Integer userId) {
        return userMenuService.getAllUserMenuByUserId(userId);
    }



}
