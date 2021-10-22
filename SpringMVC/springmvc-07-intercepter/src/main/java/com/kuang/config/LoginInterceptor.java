package com.kuang.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        //登录页面也放行
        if (request.getRequestURI().contains("goLogin"))
        {
            return true;
        }
        // 说明第一次登录
        if (request.getRequestURI().contains("login"))
        {
            return true;
        }

        //放行：判断什么情况下登录了
        if (session.getAttribute("userLoginInfo") != null) {
            return true;
        }

        //判断什么情况下没有登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);

        return false;
    }
}
