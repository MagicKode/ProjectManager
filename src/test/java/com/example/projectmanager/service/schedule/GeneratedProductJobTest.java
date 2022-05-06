package com.example.projectmanager.service.schedule;

import com.example.projectmanager.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;


@ExtendWith(MockitoExtension.class)
class GeneratedProductJobTest {

    @Mock
    ProductService productService;

    @InjectMocks
    private GeneratedProductJob testSubject;

    @Value("${scheduler.interval}")
    Integer quantity;

    @Test
    void shouldScheduleProduct() {
        //given
        productService.insertRandomProducts(quantity);

        //when
        testSubject.productScheduler();
    }
}