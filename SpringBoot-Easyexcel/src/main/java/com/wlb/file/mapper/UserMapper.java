package com.wlb.file.mapper;

import com.wlb.file.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    // 查询所有用户信息
    List<User> getAll();

    // 保存用户信息
    void saveBatch(List<User> list);
}
