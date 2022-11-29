package com.example.kafka.kafka;

import java.util.UUID;

import com.example.kafka.model.Email;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class KafkaProducer {

    @Value("${kafka.config.topic.id}")
    private String topicId;
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(final @RequestBody Email data) {
        final String key = UUID.randomUUID().toString();
        String generatedString = RandomStringUtils.randomAlphabetic(10);

        String[] resultNewEmail = data.getEmail().split("@");
        resultNewEmail[0] = generatedString;
        data.setEmail(resultNewEmail[0]+"@"+resultNewEmail[1]);
        data.setIdemail(key);

        kafkaTemplate.send(topicId, key, data.toString());
    }

}
