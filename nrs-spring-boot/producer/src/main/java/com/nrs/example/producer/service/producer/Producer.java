package com.nrs.example.producer.service.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nrs.example.producer.domain.Email;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class Producer {

    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendMessage(Email email) throws JsonProcessingException {

        final String key = UUID.randomUUID().toString();
        String generatedString = RandomStringUtils.randomAlphabetic(10);

        String[] resultNewEmail = email.getEmail().split("@");
        resultNewEmail[0] = generatedString;
        email.setEmail(resultNewEmail[0]+"@"+resultNewEmail[1]);
        email.setIdEmail(key);

        String mensage = objectMapper.writeValueAsString(email);
        kafkaTemplate.send(orderTopic, mensage);

        log.info("food order produced {}", mensage);

        return "message sent " + mensage;
    }
}
