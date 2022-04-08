package com.example.projectmanager.service.impl;

import com.example.projectmanager.entity.User;


public interface UserInterface {

    boolean createUser(User user);

    User getUserByName(String name);

    User getUserById(Long id);

    void deleteUserById(Long id);

    void deleteAllUsers();
}
