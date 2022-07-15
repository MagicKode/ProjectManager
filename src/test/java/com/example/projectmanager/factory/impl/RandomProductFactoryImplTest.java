package com.example.projectmanager.factory.impl;

import com.example.projectmanager.model.entity.Product;
import com.example.projectmanager.model.entity.Retailer;
import com.example.projectmanager.model.entity.enums.RetailerName;
import com.example.projectmanager.repository.RetailerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.projectmanager.model.entity.enums.RetailerName.RET_A;
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
    private final RetailerName name = RET_A;

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
