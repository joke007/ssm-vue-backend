package com.example.mapper;

import com.example.pojo.Role;
import com.example.pojo.User;

import java.util.List;

public interface UserMapper {
    // 插入用户
    public int insertUser(User user);

    // 查询所有用户
    public List<User> selectAllUsers();

    // 查询某个用户
    public User selectUser(User user);

    // 查询当前用户的角色
    public List<Role> selectRoleByUserId(String id);
}
