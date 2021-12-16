package com.example.service;

import com.example.pojo.User;

import java.util.Map;

public interface UserService {
    // 用户注册
    public int userRegister(Map<String, Object> userInfo);

    // 用户登录
    public Map<String, Object> userLogin(User user);

    // 查询用户
    public User getUser(User user);

    // 重置密码
    public int resetPassword(Map<String, Object> userInfo);
}
