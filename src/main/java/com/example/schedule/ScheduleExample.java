package com.example.schedule;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.util.HttpClientComponent;

import org.quartz.DisallowConcurrentExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 定时任务
 */
@Component
@DisallowConcurrentExecution
public class ScheduleExample {

    @Autowired
    private UserService userService;

    @Scheduled(cron = "0/1000000 * * * * ?")  //每1000000秒执行一次
    public void excTask(){
        System.out.println("定时任务执行，执行时间是："+new Date());
        List<User> users = userService.getUsers();
        System.out.println("查询数据库user表的全部值是:"+users);

        Map<String, Object> map = new HashMap<>();

        map.put("X-Shopify-Access-Token", "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");

        HttpClientComponent.doGet("https://amelie-home-shop.myshopify.com/admin/api/2021-10/customers.json", "UTF-8", map);

//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("commentId", "13026194071");
//        HttpClientComponent.doPost("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=13026194071", jsonObject);
    }
}
