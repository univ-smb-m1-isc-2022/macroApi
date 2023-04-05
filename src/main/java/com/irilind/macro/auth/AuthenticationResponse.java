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
public class AuthenticationResponse {


    private String token;

    private String email;

    private Objective objective;
    private Integer size;
    private Integer id;

}
