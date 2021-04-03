package com.mps.kafka.consumer.sample;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;

@SpringBootApplication
public class KafkaConsumerApp {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerApp.class);

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApp.class, args);
    }

    @KafkaListener(topics = "${topic.name}")
    public void listenPlainText(ConsumerRecord<String, String> consumer, Acknowledgment ack) {
        logger.info("Message: {} - topic: {} - partition: {} - offset: {}",
                consumer.value(), consumer.topic(), consumer.partition(), consumer.offset());
        ack.acknowledge();
    }

//    @KafkaListener(topics = "${topic.name}")
//    public void listenAvroMessage(ConsumerRecord<String, Car> consumer, Acknowledgment ack) {
//        logger.debug("Message: {} - topic: {} - partition: {} - offset: {}",
//                consumer.value(), consumer.topic(), consumer.partition(), consumer.offset());
//        ack.acknowledge();
//    }
}
