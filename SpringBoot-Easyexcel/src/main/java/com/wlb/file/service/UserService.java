package com.wlb.file.service;

import com.wlb.file.pojo.User;

import java.util.List;

public interface UserService {
    // 查询所有用户信息
    List<User> getAll();

    // 保存用户信息
    void saveBatch(List<User> list);
}
