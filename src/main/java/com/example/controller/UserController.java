package com.example.controller;

import com.example.pojo.User;
import com.example.util.RestReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    @ResponseBody
    public RestReturn userRegister(User user) {
        System.out.println("user: " + user);
        return null;
    }
}
