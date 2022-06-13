package com.example.projectmanager.controller;

import com.example.projectmanager.model.dto.ReportMessageDto;
import com.example.projectmanager.service.JmsProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messaging/")
@RequiredArgsConstructor
public class ProduceMessageController {
    private final JmsProducer jmsProducer;

    @GetMapping()
    public ResponseEntity<Void> sendMessage(@RequestBody ReportMessageDto reportMessageDto) {
        jmsProducer.sendMessage(reportMessageDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
