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
public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String email;
    private Integer size;
    private String password;
    private Objective objective;
}
