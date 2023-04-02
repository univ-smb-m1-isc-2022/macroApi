package com.irilind.macro.menu;

import com.irilind.macro.foods.Food;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    <Optional> Food findByName(String name);

    List<Menu> findAllByNameStartingWith(String startingChar, PageRequest pageable);
}
