package com.boda2.delieats.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boda2.delieats.entity.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
