package com.mps.kafka.producer.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Value("${topic.name}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplatePlainText;

//    @Autowired
//    private KafkaTemplate<String, Car> kafkaTemplateAvroMessage;

    public void sendMessage(String message) {
        kafkaTemplatePlainText.send(topic, message);
    }
}
