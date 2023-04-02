package com.irilind.macro.menu;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class MenuService  {

    MenuRepository repository;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public Menu createMenu(Menu menu) {
        return repository.save(menu);
    }

    //adding the pageable parameter
    public List<Menu> getAllMenuStartingWith(@RequestParam("startingChar") String startingChar){
        PageRequest pageRequest = PageRequest.of(0, 10);
        return repository.findAllByNameStartingWith(startingChar, pageRequest);
    }
}
