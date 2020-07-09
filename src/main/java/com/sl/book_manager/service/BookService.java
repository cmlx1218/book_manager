package com.sl.book_manager.service;

import com.sl.book_manager.persist.entity.Book;
import com.sl.book_manager.persist.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc
 * @Author cmlx
 * @Date 2020-7-8 0008 18:06
 */
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> findAll() {
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    public void save(Book book) {
        Book byName = bookRepository.findByName(book.getName());
        if (byName == null) {
            Book save = bookRepository.save(book);
        }
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}
