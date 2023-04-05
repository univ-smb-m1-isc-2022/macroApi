package com.irilind.macro.weight;

import com.irilind.macro.foods.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeightRepository extends JpaRepository<Weight, Integer> {

    List<Weight> findAllByUserId(Integer userId);

}
