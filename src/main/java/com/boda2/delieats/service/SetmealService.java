package com.boda2.delieats.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boda2.delieats.dto.SetmealDto;
import com.boda2.delieats.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    /*
    新增套餐，保存套餐和菜品关系
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，删除套餐和菜品关联数据
     * @param ids
     */
    public void removeWithDish(List<Long> ids);
}
