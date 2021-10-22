package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void test() {
        // 第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一：执行SQL
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        // 关闭sqlSession;
        sqlSession.close();
    }

    @Test
    public void getUserById() {
        SqlSession sessoin = MybatisUtils.getSqlSession();
        UserMapper mapper = sessoin.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sessoin.close();
    }

    @Test
    public void getUserLike() {
        SqlSession sessoin = MybatisUtils.getSqlSession();
        UserMapper mapper = sessoin.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("%ha%");
        for (User user : userList) {
            System.out.println(user);
        }
        sessoin.close();
    }


    // 增删改需要提交事务
    @Test
    public void addUser() {
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(6, "haha", "123321"));
        if (res > 0) {
            System.out.println(res);
        }
        // 提交事务
        session.commit();
        session.close();

    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(5,"欧派","112233"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser()
    {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(6);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }



    @Test
    public void addUser2()
    {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map = new HashMap<String,Object>();

        map.put("userid",5);
        map.put("username","java");
        map.put("password","132211");

        mapper.addUser2(map);

        sqlSession.commit();
        sqlSession.close();
    }
}
