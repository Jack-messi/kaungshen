package com.kuang.service;

import com.kuang.dao.UserDao;
import com.kuang.dao.UserDaoImpl;
import com.kuang.dao.UserDaoMySqlImpl;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    //利用set实现
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

//    private UserDao userDao = new UserDaoMySqlImpl();

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
