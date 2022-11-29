package com.example.kafka.controller;

import com.example.kafka.kafka.KafkaProducer;
import com.example.kafka.model.Email;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/email")
public class EmailController {

    private final KafkaProducer kafkaProducer;

    @PostMapping
    public void send(@RequestBody Email email) {
        kafkaProducer.send(email);
    }
}
