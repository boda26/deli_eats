package com.boda2.delieats.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boda2.delieats.common.CustomException;
import com.boda2.delieats.entity.Category;
import com.boda2.delieats.entity.Dish;
import com.boda2.delieats.entity.Setmeal;
import com.boda2.delieats.mapper.CategoryMapper;
import com.boda2.delieats.service.CategoryService;
import com.boda2.delieats.service.DishService;
import com.boda2.delieats.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;

    /*
    根据id删除分类，删除前进行判断是否关联菜品
     */
    @Override
    public void remove(Long id) {
        // 查询当前分类是否关联菜品，如果已经关联，抛出异常
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<Dish>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int count1 = dishService.count(dishLambdaQueryWrapper);

        if (count1 > 0) {
            throw new CustomException("This category is connected to one or more dishes!");
        }

        // 查询当前分类是否关联套餐，如果已经关联，抛出异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        if (count2 > 0) {
            throw new CustomException("This category is connected to one or more setmeals!");
        }

        super.removeById(id);
    }
}
