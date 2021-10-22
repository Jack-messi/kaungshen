package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c3")
public class ControllerTest3 {

    @RequestMapping("/t1")
    public String test1(Model model){
        model.addAttribute("msg","这分公司c3/t1");
        return "test";
    }

    // 前端接收的是一个对象： id，name，age

    /*
    * 1.接收前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用
    * 2.假设传递的是一个对象User，匹User对象中的字段名；如果名字一致则OK，否则，匹配不到
    *
    *
    * */

    public String test3(ModelMap map)
    {

        return "test";
    }
}
