package com.boda2.delieats.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boda2.delieats.entity.Employee;
import com.boda2.delieats.mapper.EmployeeMapper;
import com.boda2.delieats.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {
}
