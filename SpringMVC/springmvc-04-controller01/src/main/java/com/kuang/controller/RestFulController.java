package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {

//    @RequestMapping(name = "/add/{a}/{b}",method = RequestMethod.GET)
    @PostMapping( "/add/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable int b, Model model) {

        int res = a + b;
        model.addAttribute("msg","结果1为："+res);
        return "test";
    }

    //http://localhost:8080/add/1/4
    @GetMapping( "/add/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model) {

        int res = a + b;
        model.addAttribute("msg","结果2为："+res);
        return "test";
    }
}
