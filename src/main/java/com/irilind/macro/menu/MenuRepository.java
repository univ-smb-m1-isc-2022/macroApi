package com.irilind.macro.menu;

import com.irilind.macro.foods.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
    <Optional> Food findByName(String name);


}
