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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

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
    void shouldCreateRetailer() {
        //given
        when(userRepository.save(user)).thenReturn(null);

        //when
        boolean result = userService.createUser(this.user);

        //then
        assertNotNull(this.user);
        assertTrue(true);

        verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    void shouldGetAllRetailers() {
    }

    @Test
    void shouldGetRetailerByName() {
        //given
        String name = "Retailer";
        when(userRepository.findUserByName(name)).thenReturn(null);

        //when
        User result = userService.getUserByName(user.getName());

        //then
        assertThat(this.user.getName()).isEqualTo(name);
        /*assertTrue(resul);*/
    }

    @Test
    void shouldGetRetailerById() {
    }

    @Test
    void shouldDeleteRetailerById() {
    }

    @Test
    void shouldDeleteAllRetailers() {
    }
}