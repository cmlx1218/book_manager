package com.sl.book_manager.persist.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @Desc
 * @Author cmlx
 * @Date 2020-7-8 0008 17:05
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String nickName;
    private String password;
    private String sex;

}
