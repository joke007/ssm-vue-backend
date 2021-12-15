package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int userRegister(User user) {
        int userId = userMapper.insertUser(user);
        System.out.println("userId: " + userId);
        return userId;
    }

    @Override
    public void userLogin(User user) {

    }

    @Override
    public User getUser(User user) {
        return null;
    }
}
