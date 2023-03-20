package com.irilind.macro.foods;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    <Optional>Food findByName(String name);

}
