package com.example.projectmanager.service;

import com.example.projectmanager.model.dto.ReportMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JmsProducer {
    private final JmsTemplate jmsTemplate;

    @Value("${activemq.topic}")
    private String topic;

    public void sendMessage(ReportMessageDto reportMessageDto) {
        jmsTemplate.convertAndSend(topic, reportMessageDto);
    }
}