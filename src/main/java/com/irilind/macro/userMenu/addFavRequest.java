package com.irilind.macro.userMenu;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class addFavRequest {

    private Number menu_id;
    private Number user_id;
}
