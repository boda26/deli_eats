package com.boda2.delieats.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boda2.delieats.entity.DishFlavor;
import com.boda2.delieats.mapper.DishFlavorMapper;
import com.boda2.delieats.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
