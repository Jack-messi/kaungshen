package com.kuang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/t1")
    public String test1(String name, Model model)
    {
        //1、接收到前端的参数为
        System.out.println("接收到前端的参数为: "+ name);

        //2、将发挥的结果传递给前端， Model
        model.addAttribute("msg",name);

        //3、视图跳转
        return "test";
    }
}
