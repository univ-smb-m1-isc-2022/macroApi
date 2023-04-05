package com.irilind.macro.auth;

import com.irilind.macro.user.Objective;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {
    private String email;
    private String token;
    private Integer size;
    private Objective objective;
    private Integer id;
}
