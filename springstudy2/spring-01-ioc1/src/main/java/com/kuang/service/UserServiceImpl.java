package com.kuang.service;

import com.kuang.dao.UserDao;
import com.kuang.dao.UserDaoMysqlImpl;
import com.kuang.dao.UserDaoOracleImpl;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

//    private UserDao userDao = new UserDaoOracleImpl();
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
