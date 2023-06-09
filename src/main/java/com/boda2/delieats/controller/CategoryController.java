package com.boda2.delieats.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boda2.delieats.common.R;
import com.boda2.delieats.entity.Category;
import com.boda2.delieats.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
分类管理
 */
@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /*
    新增分类
     */
    @PostMapping
    public R<String> save(@RequestBody Category category) {
        log.info("category: {}", category);
        categoryService.save(category);
        return R.success("Added new category!");
    }

    /*
    分页查询
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize) {
        // 分页构造器
        Page<Category> pageInfo = new Page<>(page, pageSize);

        //条件构造器
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();

        // 添加排序条件，根据sort排序
        queryWrapper.orderByAsc(Category::getSort);

        // 进行分页查询
        categoryService.page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }
    /*
    根据id删除分类
     */
    @DeleteMapping
    public R<String> delete(Long ids) {
        log.info("deleting category: {}", ids);
        categoryService.remove(ids);
        //categoryService.removeById(ids);
        return R.success("Category deleted!");
    }

    /*
    根据id修改分类信息
     */
    @PutMapping
    public R<String> update(@RequestBody Category category) {
        log.info("updating category info: {}", category);
        categoryService.updateById(category);
        return R.success("Category updated!");
    }

    /**
     * find category data
     * @param category
     * @return
     */
    @GetMapping("/list")
    public R<List<Category>> list(Category category) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(category.getType() != null, Category::getType, category.getType());
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);
        List<Category> list = categoryService.list(queryWrapper);
        return R.success(list);
    }
}
