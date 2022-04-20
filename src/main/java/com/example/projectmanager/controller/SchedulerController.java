package com.example.projectmanager.controller;

import com.example.projectmanager.service.schedule.GeneratedProductJob;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class SchedulerController {

    private final GeneratedProductJob generatedProductJob;

    @GetMapping()
    public void generateProductByScheduler(){
        generatedProductJob.createRandomProductsEveryFiveMinutes();
    }
}
