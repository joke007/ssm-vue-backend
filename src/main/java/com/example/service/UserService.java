package com.example.service;

import com.example.pojo.User;

public interface UserService {
    // 用户注册
    public void userRegister(User user);

    // 用户登录
    public void userLogin(User user);
}
