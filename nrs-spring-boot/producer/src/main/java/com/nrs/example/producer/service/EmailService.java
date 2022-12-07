package com.nrs.example.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nrs.example.producer.domain.Email;
import com.nrs.example.producer.service.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    private final Producer producer;

    @Autowired
    public EmailService(Producer producer) {
        this.producer = producer;
    }

    public String createFoodOrder(Email email) throws JsonProcessingException {
        return producer.sendMessage(email);
    }
}
