package com.irilind.macro.foods;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Food {
    @Id
    @GeneratedValue
    private Integer id;

    //Make a unique constraint for name
    @Column(unique = true)
    private String name;

    private String type;
    private Float protein;
    private Float carbs;
    private Float lipids;
    private Float caloriesFor100g;
    private Float quantity;
}
