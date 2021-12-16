package com.example.controller;

import com.example.pojo.Role;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.util.ResponseResult;

import com.example.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    // 前端请求默认是application/json格式，所以这里需要写@RequestBody，用来接收json格式的传参
    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult userRegister(@RequestBody Map<String, Object> userInfo) {
        System.out.println("userInfo: " + userInfo);

        int userId = userService.userRegister(userInfo);

        if (userId != 0) {
            return new ResponseResult().ok();
        }

        return new ResponseResult().code(400).message("请求失败");
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult userLogin(@RequestBody User user) {
        int userId = 0;
        String username = "";
        int identity = 0;
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> userMap = new HashMap<>();

        Map<String, Object> currentUser = userService.userLogin(user);

        if (currentUser != null) {
            userId = (int) currentUser.get("id");
            username = (String) currentUser.get("username");
            identity = ((Role) currentUser.get("role")).getId();

            String token = TokenUtil.sign(userId, username, identity);
            System.out.println("token: " + token);

            // 登录者的基本信息
            userMap.put("userId", userId);
            userMap.put("username", username);
            userMap.put("identity", identity);

            result.put("token", token);
            result.put("userInfo", userMap);

            return new ResponseResult().ok().data(result);
        }

        return new ResponseResult().code(400).message("请求失败");
    }

    /**
     * 重置密码
     * @return
     */
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult resetPassword(@RequestBody Map<String, Object> userInfo) {
        int userId = userService.resetPassword(userInfo);

        if (userId != 0) {
            return new ResponseResult().ok();
        }
        return new ResponseResult().error().message("该账号不存在");
    }

    @GetMapping("index")
    @ResponseBody
    public ResponseResult index(){
//        ResponseResult ok = ResponseResult.ok();
//        ok.setData("FUCK");
//        return ok;
//         ResponseEntity.ok("fucke");

        return new ResponseResult().ok().data(123);
    }
}
