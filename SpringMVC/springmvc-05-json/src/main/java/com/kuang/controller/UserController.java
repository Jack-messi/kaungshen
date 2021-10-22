package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kuang.pojo.User;
import com.kuang.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController
public class UserController {

    @RequestMapping("j1")
//    @ResponseBody
    public String json1() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        //创建对象
        User user = new User(32,"刘丹丹",85);

        String str = mapper.writeValueAsString(user);

        return str;
    }

    @RequestMapping("j2")
//    @ResponseBody
    public String json2() throws JsonProcessingException {


        List<User> userList = new ArrayList<>();

        //创建对象
        User user1 = new User(32,"刘丹丹1",85);
        User user2 = new User(32,"刘丹丹2",85);
        User user3 = new User(32,"刘丹丹3",85);
        User user4 = new User(32,"刘丹丹4",85);
        User user5 = new User(32,"刘丹丹5",85);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

        String string = JSON.toJSONString(userList);

        return string;
    }

    @RequestMapping("j3")
//    @ResponseBody
    public String json3() throws JsonProcessingException {

//        ObjectMapper mapper = new ObjectMapper();
//
//        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false);
//
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //指定日期格式
//        mapper.setDateFormat(sdf);
//        Date date = new Date();
//
//        String str = mapper.writeValueAsString(date);

        Date date = new Date();


        return JsonUtils.getJson(date);
    }
}
