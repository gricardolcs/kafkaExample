package com.nrs.example.consumer.service;

import com.nrs.example.consumer.domain.Email;
import com.nrs.example.consumer.repository.EmailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    private final EmailRepository emailRepository;

    @Autowired
    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public void persistFoodOrder(Email email) {
        Email persistedEmail = emailRepository.save(email);
        log.info("food order persisted {}", persistedEmail);
    }

}
