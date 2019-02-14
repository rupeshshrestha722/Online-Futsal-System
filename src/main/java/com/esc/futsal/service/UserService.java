package com.esc.futsal.service;

import com.esc.futsal.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<User> getAllUser();
    void addUser(User user);
    void editUser(User user);
    void deleteUser(long userId);
    User getById(long userId);
    Iterable<User> listUserByFirstName(String firstName);
    User findByUsername(String username);



    public User getUserByUsername(String username);
}
