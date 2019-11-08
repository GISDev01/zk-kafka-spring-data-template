package com.gisdev01.kafka.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class SenderPrimary {
    private static final Logger LOG = LoggerFactory.getLogger(SenderPrimary.class);
    private static final String TEST_TOPIC_NAME = "stage001topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String payload) {

        LOG.info("Sending Message: '{}' ", payload);

        kafkaTemplate.send(TEST_TOPIC_NAME, payload);
    }

}
