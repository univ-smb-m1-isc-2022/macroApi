package com.irilind.macro.weight;

import com.irilind.macro.foods.Food;
import com.irilind.macro.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

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

    private Double weight;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
}