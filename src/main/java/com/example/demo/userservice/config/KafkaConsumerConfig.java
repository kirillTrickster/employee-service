package com.example.demo.userservice.config;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class KafkaConsumerConfig {

    private final CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "my_topic", groupId = "group_id")
    public void receive(String message) {
        System.out.println("Received message: " + message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
