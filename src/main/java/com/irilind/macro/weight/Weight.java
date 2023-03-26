package com.irilind.macro.weight;

import com.irilind.macro.foods.Food;
import com.irilind.macro.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Weight {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}