package com.example.projectmanager.service;

import com.example.projectmanager.entity.role.Retailer;
import com.example.projectmanager.repository.RetailerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class RetailerServiceTest {

    @Mock
    RetailerRepository retailerRepository;

    @InjectMocks
    RetailerService testObject;

    Retailer retailer;

    @BeforeEach
    void init(){
        retailer = new Retailer();
        retailer.setId(1L);
        retailer.setName("Retailer");
    }

   /* @Test
    void shouldCreateRetailers() {
        //given
        when(userRepository.save(user)).thenReturn(null);

        //when
        testObject.createRetailers(this.user);

        //then
        assertNotNull(this.user);
        assertTrue(true);

        verify(userRepository, Mockito.times(1)).save(user);
    }*/

   /* @Test
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
    }*/
}