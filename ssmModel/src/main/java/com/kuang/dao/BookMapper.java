package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;

public interface BookMapper {

    // 增加一本书
    int addBook(Books books);

    // 删除一本书
    int deleteBookById(@Param("BookId") int id);

    // 更新一本书
    int updateBook(Books books);

    // 查询一本书
    Books queryBookById(@Param("BookId") int id);

    // 查询全部的书
    List<Books> queryAllBook();

    // 根据书籍名称，进行查询
    Books queryBookByName(@Param("bookName") String bookName);
//  select * from ssmbuild.books where bookName like concat('%',#{bookName},'%')

}
