package com.irilind.macro.weight;

import com.irilind.macro.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import org.springframework.data.annotation.CreatedDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Weight {
    @Id
    @GeneratedValue()
    private Integer id;

    @Column(nullable = false)
    private Double weight;

    @Column(name = "created_at", updatable = false)
    @CreatedDate
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }
}