package com.example.projectmanager.service;

import com.example.projectmanager.entity.User;

import com.example.projectmanager.repository.UserRepository;
import com.example.projectmanager.service.impl.UserInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserInterface {

    private final UserRepository userRepository;

    @Override
    public boolean createUser(User user) {  //ограниченная количеством юзеров регистрация
        User[] users = new User[3];
        for (int i = 0; i <= users.length; i++) {
            userRepository.save(user);
        }
        return true;
    }

    @Override
    public User getUserByName(String name) {
        log.info("found user with name = {}", name);
       return userRepository.findUserByName(name);
    }

    @Override
    public User getUserById(Long id) {
        log.info("found user with id = {}", id);
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUserById(Long id) {
        log.info("deleted user with id = {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        log.info("all users deleted");
        userRepository.deleteAll();
    }
}
