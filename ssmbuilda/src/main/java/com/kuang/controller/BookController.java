package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> lis = bookService.queryAllBook();
        model.addAttribute("list",lis);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddPaper()
    {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books)
    {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUPdateBook")
    public String toUpdateBook(Model model,int id){
        Books books = bookService.queryBookById(id);
        return "redirect:/book/allBook";
    }


}
