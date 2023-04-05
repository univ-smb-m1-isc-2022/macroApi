package com.irilind.macro.userMenu;

import com.irilind.macro.foods.Food;
import com.irilind.macro.menu.Menu;
import com.irilind.macro.user.User;
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
@Table(name = "user_menu")
public class UserMenu{

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    //non nullable
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}