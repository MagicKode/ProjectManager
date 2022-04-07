package com.example.projectmanager.service;

import com.example.projectmanager.entity.User;

import com.example.projectmanager.repository.UserRepository;
import com.example.projectmanager.service.impl.UserInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserInterface {

    private final UserRepository userRepository;

    @Override
    public boolean createUser(User user) {
        String login = user.getLogin();
        if (userRepository.findUserByName(user.getName()) != null)
            return false;
        user.setActive(true);
        //retailer.getRoles().add(Role.ROLE_RETAILER);
        log.info("Saving new User with login: {}", login);
        userRepository.save(user);
        return true;

    }

    @Override
    public List<User> getAllUsers() { // достайм всех продавцов
        return userRepository.findAll();
    }

    @Override
    public User getUserByName(String name) { // достаём продавца по имени
        User user = new User();
        if (user.getName().equals(name)) {
            return userRepository.findUserByName(name);
        }else {
            return null;
        }
    }

    @Override
    public User getUserById(Long id) {  // достаём продавца по id
        return userRepository.findById(id).orElse(null); // если нет ни одного, тогда null
    }

    @Override
    public void deleteUserById(Long id) { //удаляем продавца по id
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() { //удаляем всех
        userRepository.deleteAll();
    }


}
