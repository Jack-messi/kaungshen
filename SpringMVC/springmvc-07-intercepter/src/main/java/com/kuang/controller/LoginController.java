package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("goLogin")
    public String login()
    {
        return "login";
    }


    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){

        System.out.println("username: " +username);
        //把用户的信息保存在session中
        session.setAttribute("userLoginInfo",username);
        model.addAttribute("username",username);

        return "main";
    }

    @RequestMapping("/gouOut")
    public String gouOut(HttpSession session){

        session.removeAttribute("userLoginInfo");

        return "main";
    }
}
