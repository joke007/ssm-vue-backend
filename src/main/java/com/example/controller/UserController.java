package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.util.ResponseResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 前端请求默认是application/json格式，所以这里需要写@RequestBody，用来接收json格式的传参
    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult userRegister(@RequestBody User user) {

        System.out.println("user: " + user);

        int userId = userService.userRegister(user);


        System.out.println("new ResponseResult().ok().data(userId): " + new ResponseResult().ok().data(userId));

        if (userId != 0) {
            return new ResponseResult().ok().data(userId);
        }

        return new ResponseResult().code(400).message("请求失败");
    }
}
