package com.irilind.macro.menu;

import com.irilind.macro.foods.Food;
import com.irilind.macro.user.User;
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
public class Menu {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String name;


}
