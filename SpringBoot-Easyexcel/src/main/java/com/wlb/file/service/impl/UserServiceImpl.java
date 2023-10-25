package com.wlb.file.service.impl;

import com.wlb.file.pojo.User;
import com.wlb.file.mapper.UserMapper;
import com.wlb.file.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public void saveBatch(List<User> list) {
        userMapper.saveBatch(list);
    }
}
