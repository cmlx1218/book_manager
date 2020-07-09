package com.sl.book_manager.controller;

import com.sl.book_manager.persist.entity.Book;
import com.sl.book_manager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Desc
 * @Author cmlx
 * @Date 2020-7-8 0008 16:48
 */
@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "book/booklist";
    }

    @RequestMapping("/save")
    public String save(Book book) {
        bookService.save(book);
        return "redirect:/book/findAll";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        bookService.delete(id);
        return "redirect:/book/findAll";
    }

}
