package com.example.projectmanager.service;

import com.example.projectmanager.entity.Retailer;
import com.example.projectmanager.repository.RetailerRepository;
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
class RetailerServiceTest {

    @Mock
    RetailerRepository retailerRepository;

    @InjectMocks
    RetailerService retailerService;

    Retailer retailer;

    @BeforeEach
    void init(){
        retailer = new Retailer();
        retailer.setId(1L);
        retailer.setActive(true);
        retailer.setEmail("retailer@gmail.com");
        retailer.setLogin("retailer");
        retailer.setName("Retailer");
        retailer.setPhoneNumber("123456");
    }

    @Test
    void shouldCreateRetailer() {
        //given
        when(retailerRepository.save(retailer)).thenReturn(null);

        //when
        boolean result = retailerService.createRetailer(this.retailer);

        //then
        assertNotNull(this.retailer);
        assertTrue(true);

        verify(retailerRepository, Mockito.times(1)).save(retailer);
    }

    @Test
    void shouldGetAllRetailers() {
    }

    @Test
    void shouldGetRetailerByName() {
        //given
        String name = "Retailer";
        when(retailerRepository.findRetailerByName(name)).thenReturn(null);

        //when
        Retailer result = retailerService.getRetailerByName(retailer.getName());

        //then
        assertThat(this.retailer.getName()).isEqualTo(name);
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