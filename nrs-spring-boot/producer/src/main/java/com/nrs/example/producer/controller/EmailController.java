package com.nrs.example.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nrs.example.producer.domain.Email;
import com.nrs.example.producer.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public String createFoodOrder(@RequestBody Email foodOrder) throws JsonProcessingException {
        log.info("create an email request received");
        return emailService.createFoodOrder(foodOrder);
    }
}
