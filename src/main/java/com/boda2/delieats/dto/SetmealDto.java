package com.boda2.delieats.dto;

import com.boda2.delieats.entity.Setmeal;
import com.boda2.delieats.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
