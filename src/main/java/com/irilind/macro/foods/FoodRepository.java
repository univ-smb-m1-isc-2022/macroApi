package com.irilind.macro.foods;

import com.irilind.macro.menu.Menu;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer> {


    List<Food> findAllByNameStartingWith(String startingChar, PageRequest pageable);

}
