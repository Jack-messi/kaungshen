package com.kuang.dao;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    // 获取老师
    //List<Teacher> getTeacher();

    //获取指定老师下的所有学生·及老师的信息
    Teacher getTeacher(@Param("tid") int idea);

    Teacher getTeacher2(@Param("tid") int idea);
}
