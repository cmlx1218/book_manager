package com.sl.book_manager.persist.repository;

import com.sl.book_manager.persist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Desc
 * @Author cmlx
 * @Date 2020-7-8 0008 17:15
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserNameAndPassword(String username,String password);

}
