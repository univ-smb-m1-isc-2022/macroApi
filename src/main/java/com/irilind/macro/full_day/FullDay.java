package com.irilind.macro.full_day;

import com.irilind.macro.menu.Menu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FullDay {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Date date;

    @ManyToMany
    @JoinTable(
            name = "full_day_menu",
            joinColumns = @JoinColumn(name = "full_day_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private List<Menu> menu;


}
