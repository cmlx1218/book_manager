package com.sl.book_manager.persist.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @Desc
 * @Author cmlx
 * @Date 2020-7-8 0008 17:07
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String author;
    private String publisher;

}
