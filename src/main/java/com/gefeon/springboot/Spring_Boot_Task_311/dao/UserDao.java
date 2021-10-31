package com.gefeon.springboot.Spring_Boot_Task_311.dao;

import com.gefeon.springboot.Spring_Boot_Task_311.model.User;
import java.util.List;

public interface UserDao {

    void addUser(User user);

    void editUser(User updatedUser);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> listUsers();

    User getUserByUsername(String username);
}