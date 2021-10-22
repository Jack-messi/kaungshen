package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> selectUser();

    User selectUserById(int id);

    User selectUserByNP(@Param("username") String username, @Param("pwd") String pwd);

//    User selectUserByNP2(Map<String,Object> map);

    int addUser(User user);
}
