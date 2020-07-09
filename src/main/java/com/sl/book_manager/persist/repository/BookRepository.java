package com.sl.book_manager.persist.repository;

import com.sl.book_manager.persist.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Desc
 * @Author cmlx
 * @Date 2020-7-8 0008 17:15
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByName(String name);

}
