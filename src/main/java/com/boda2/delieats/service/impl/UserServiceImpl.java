package com.boda2.delieats.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boda2.delieats.entity.User;
import com.boda2.delieats.mapper.UserMapper;
import com.boda2.delieats.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
