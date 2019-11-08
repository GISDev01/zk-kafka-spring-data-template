package com.gisdev01.kafka.consumers;

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
    private static final String TEST_TOPIC_NAME = "stage001topic";

    private CountDownLatch countDownLatch = new CountDownLatch(WAIT_TIME_SECONDS);

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    @KafkaListener(topics = TEST_TOPIC_NAME)
    public void receive(String receivedMsg) {
        LOGGER.info(TEST_TOPIC_NAME + " topic consuming message: '{}'",
                receivedMsg);

        // Wait 1 second
        countDownLatch.countDown();
    }
}
