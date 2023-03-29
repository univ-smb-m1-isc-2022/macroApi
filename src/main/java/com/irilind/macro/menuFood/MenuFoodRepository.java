package com.irilind.macro.menuFood;

import com.irilind.macro.foods.Food;
import com.irilind.macro.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface MenuFoodRepository extends JpaRepository<MenuFood, Integer> {

    //find all by menuId
    Optional<MenuFood> findByMenuId(Integer menuId);

    List<MenuFood> findAllByMenuName(String menuName);


}
