package com.example.projectmanager.service.impl;

import com.example.projectmanager.entity.User;

import java.util.List;

public interface UserInterface {

    boolean createUser(User user);

    List<User> getAllUsers();

    User getUserByName(String name);

    User getUserById(Long id);

    void deleteUserById(Long id);

    void deleteAllUsers();
}
