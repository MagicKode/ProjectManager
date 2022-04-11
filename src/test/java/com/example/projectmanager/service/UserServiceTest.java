package com.example.projectmanager.service;

import com.example.projectmanager.entity.User;
import com.example.projectmanager.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService testObject;

    User user;

    @BeforeEach
    void init(){
        user = new User();
        user.setId(1L);
        user.setActive(true);
        user.setLogin("retailer");
        user.setName("Retailer");
    }

    @Test
    void shouldCreateUser() {
        //given
        when(userRepository.save(user)).thenReturn(null);

        //when
        testObject.createUser(this.user);

        //then
        assertNotNull(this.user);
        assertTrue(true);

        verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    void shouldGetUserByName() {
        //given
        User user = new User();
        String name = "Retailer";
        user.setName(name);
        when(userRepository.findUserByName(name)).thenReturn(null);

        //when
        testObject.getUserByName(user.getName());

        //then
        assertThat(this.user.getName()).isEqualTo(name);
        assertEquals("Retailer", user.getName());
    }

    @Test
    void shouldGetUserById() {
        //given
        User user = new User();
        Long id = 1L;
        user.setId(id);
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        //when
        testObject.getUserById(user.getId());

        //then
        assertEquals(1L, id);

        verify(userRepository, times(1)).findById(user.getId());
    }

    @Test
    void shouldDeleteUserById() {
        //given
        User user = new User();
        Long id = 1L;
        user.setId(id);

        //when
        testObject.deleteUserById(user.getId());

        //then
        assertEquals(1L, id);

        verify(userRepository, times(1)).deleteById(user.getId());
    }

    @Test
    void shouldDeleteAllUsers() {
        //given
        List<User> users = new ArrayList<>();
        users.add(user);

        //when
        testObject.deleteAllUsers();

        //then
        assertEquals(1, users.size());

        verify(userRepository, times(1)).deleteAll();
    }
}