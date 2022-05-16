package com.example.projectmanager.factory.impl;

import com.example.projectmanager.entity.Product;
import com.example.projectmanager.entity.Retailer;
import com.example.projectmanager.entity.retName.RetailerName;
import com.example.projectmanager.repository.RetailerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RandomProductFactoryImplTest {

    @Mock
    RetailerRepository retailerRepository;

    @InjectMocks
    private RandomProductFactoryImpl testSubject;

    private final String name = RetailerName.RET_A.name();

    @Test
    void shouldCreateRandomProduct() {
        //given
        Retailer retailer = new Retailer();
        retailer.setName(name);
        when(retailerRepository.findByName(name)).thenReturn(retailer);

        //when
        Product result = testSubject.createRandomProduct();

        //then
        assertNotNull(result);
        verify(retailerRepository, times(1)).findByName(name);
    }
}
