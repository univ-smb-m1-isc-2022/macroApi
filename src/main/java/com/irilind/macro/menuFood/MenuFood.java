package com.irilind.macro.menuFood;

import com.irilind.macro.foods.Food;
import com.irilind.macro.menu.Menu;
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
@Table(name = "menu_food")
public class MenuFood {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    //non nullable
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;
}
