package com.kuang.demo02;

public class Client {
    public static void main(String[] args) {
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.add();

        //下面把事情交给代理去做
        UserServiceImpl userService = new UserServiceImpl();

        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);

        proxy.delete();
    }
}
