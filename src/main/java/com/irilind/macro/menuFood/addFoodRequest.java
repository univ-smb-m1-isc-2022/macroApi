package com.irilind.macro.menuFood;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class addFoodRequest {
    private String quantity;
    private Number food_id;

    private Number menu_id;
}
