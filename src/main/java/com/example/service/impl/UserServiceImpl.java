package com.example.service.impl;

import com.example.mapper.RoleMapper;
import com.example.mapper.UserMapper;
import com.example.pojo.Role;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int userRegister(Map<String, Object> userInfo) {
        User user = new User();
        String username = (String) userInfo.get("username");
        String password = (String) userInfo.get("password");
        // 角色id默认为1，为普通用户
        int roleId = 1;

        if (userInfo.get("identity") != null) {
            roleId = (int) userInfo.get("identity");
        }

        user.setUsername(username);
        user.setPassword(password);

        System.out.println("user: " + user);
        System.out.println("roleId: " + roleId);


        userMapper.insertUser(user);

        // 由于没有采用User对象自动映射的方式插入数据，所以mybatis返回值一直不是插入记录的真正id。
        // 所以这里使用getId()获取插入记录的id
        int userId = user.getId();
        int row = userMapper.insertRoleIdAndUserId(userId, roleId);
        return userId;
    }

    @Override
    public Map<String, Object> userLogin(User user) {
        // 查询当前用户信息
        User currentUser = userMapper.selectUser(user);
        Map<String, Object> result = new HashMap<>();

        // 当前用户存在
        if (currentUser != null) {
            // 查询用户角色
            Role role = roleMapper.selectRoleByUserId(currentUser.getId());

            currentUser.setRole(role);

            System.out.println("role: " + role);

            result.put("id", currentUser.getId());
            result.put("username", currentUser.getUsername());
            result.put("role", currentUser.getRole());

            System.out.println("user: " + currentUser);
            return result;
        }

        return null;
    }

    @Override
    public User getUser(User user) {
        return null;
    }

    @Override
    public int resetPassword(Map<String, Object> userInfo) {
        User user = new User();
        String username = (String) userInfo.get("username");
        String newPassword = (String) userInfo.get("newPassword");

        user.setUsername(username);
        user.setPassword(newPassword);


        // 判断该用户是否存在
        User currentUser = userMapper.selectUser(user);

        // 存在该用户
        if (currentUser != null) {
            userMapper.updateUser(user);

            int userId = currentUser.getId();

            return  userId;
        }

        return 0;
    }
}
