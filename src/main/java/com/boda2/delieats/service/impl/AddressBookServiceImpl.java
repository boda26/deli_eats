package com.boda2.delieats.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boda2.delieats.entity.AddressBook;
import com.boda2.delieats.mapper.AddressBookMapper;
import com.boda2.delieats.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
