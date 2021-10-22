package com.haiwen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import javax.xml.transform.sax.SAXResult;

@Controller
public class LoginController {


    @RequestMapping("/user/login")
//    @ResponseBody  //加上就跳不到视图了
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model mode, HttpSession session) {
        //具体的业务：
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {
            //告诉用户登录失败；
            mode.addAttribute("msg", "用户名或者密码错误");
            return "index";
        }
    }
}
