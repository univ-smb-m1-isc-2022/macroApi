package com.irilind.macro.menu;

import org.springframework.stereotype.Service;

@Service
public class MenuService  {

    MenuRepository repository;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public Menu createMenu(Menu menu) {
        return repository.save(menu);
    }
}
