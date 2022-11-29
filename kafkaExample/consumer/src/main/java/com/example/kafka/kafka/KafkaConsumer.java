package com.example.kafka.kafka;

import com.example.kafka.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "${kafka.topic.id}", groupId = "${kafka.group.id}")
    public void consumer(final ConsumerRecord<String, Email> consumerRecord) {
        log.info("key: " + consumerRecord.key());
        log.info("Headers: " + consumerRecord.headers());
        log.info("Partion: " + consumerRecord.partition());
        log.info("Data: " + consumerRecord.value());
    }
}