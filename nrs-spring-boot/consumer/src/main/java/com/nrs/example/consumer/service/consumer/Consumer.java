package com.nrs.example.consumer.service.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nrs.example.consumer.domain.Email;
import com.nrs.example.consumer.domain.dto.EmailDto;
import com.nrs.example.consumer.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {

    private static final String orderTopic = "${topic.name}";

    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    private final EmailService emailService;

    @Autowired
    public Consumer(ObjectMapper objectMapper, ModelMapper modelMapper, EmailService emailService) {
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.emailService = emailService;
    }

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        EmailDto emailDto = objectMapper.readValue(message, EmailDto.class);
        Email email = modelMapper.map(emailDto, Email.class);

        emailService.persistFoodOrder(email);
    }

}
