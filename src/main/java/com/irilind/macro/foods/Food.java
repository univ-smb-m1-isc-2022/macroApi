package com.irilind.macro.foods;

import com.irilind.macro.menu.Menu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private Float protein;
    @Column(nullable = false)
    private Float carbs;
    @Column(nullable = false)
    private Float lipids;
    @Column(nullable = false)
    private Float caloriesFor100g;

    //m:n relation with menu
    @ManyToMany(mappedBy = "food")
    private List<Menu> menus;

}
