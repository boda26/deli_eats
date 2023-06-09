package com.boda2.delieats.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boda2.delieats.dto.DishDto;
import com.boda2.delieats.entity.Dish;

public interface DishService extends IService<Dish> {
    // 新增菜品
    public void saveWithFlavor(DishDto dishDto);
    // 根据id查询菜品信息和口味信息
    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);
}
