package com.tutorial.loadbalancer.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${spring.kafka.topic.userCreated}")
    public void receive(String payload) {
        LOGGER.info("received payload='{}'", payload);
        latch.countDown();
    }
}
