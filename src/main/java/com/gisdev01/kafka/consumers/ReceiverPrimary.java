package com.gisdev01.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

/**
 * Primary Kafka Consumer that checks for payload every 1 second (configurable)
 */
public class ReceiverPrimary {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverPrimary.class);

    private static final int WAIT_TIME_SECONDS = 1;

    private CountDownLatch countDownLatch = new CountDownLatch(WAIT_TIME_SECONDS);

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    @KafkaListener(topics = "stage001topic")
    public void receive(String receivedMsg) {
        LOGGER.info("stage001 topic consuming message: '{}'", receivedMsg);
        // Wait 1 second
        countDownLatch.countDown();
    }
}
