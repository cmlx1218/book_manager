package com.sl.book_manager.service;

import com.sl.book_manager.persist.entity.User;
import com.sl.book_manager.persist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Desc
 * @Author cmlx
 * @Date 2020-7-8 0008 17:14
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void register(User user) {
        User userEntity = userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
        if (userEntity == null) {
            userRepository.save(user);
        }
    }

    public User login(String username, String password) {
        User user = userRepository.findByUserNameAndPassword(username, password);
        return user;
    }

}
