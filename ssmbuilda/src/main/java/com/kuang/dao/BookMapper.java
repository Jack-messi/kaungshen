package com.kuang.dao;

import com.kuang.pojo.Books;

import java.awt.print.Book;
import java.util.List;

public interface BookMapper {

    //增加一个Book
    int addBook(Books books);

    //根据id删除一个Book
    int deteleteBookById(int id);

    //更新Book
    int upadateBook(Books books);

    //根据id查询，返回一个Book
    Books queryBookById(int id);

    //查询全部Book，返回list集合
    List<Books> queryAllBook();

}
