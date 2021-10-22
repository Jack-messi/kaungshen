package com.kuang.dao;

public class UserDaoMySqlImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("mysql 获取用户数据");
    }
}
