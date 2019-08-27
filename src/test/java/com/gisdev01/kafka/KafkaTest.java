package com.gisdev01.kafka;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.gisdev01.kafka.consumers.ReceiverPrimary;
import com.gisdev01.kafka.producers.SenderPrimary;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1,
		topics = {KafkaTest.TEST_TOPIC_NAME})
public class KafkaTest {

	static final String TEST_TOPIC_NAME = "test_topic_1";

	static final int WAIT_TIME_SEC = 10;

	@Autowired
	private ReceiverPrimary testReceiver;

	@Autowired
	private SenderPrimary testSender;

	@Test
	public void testReceive() throws Exception {
		testSender.sendMessage("Test Message string 1!");

		testReceiver.getCountDownLatch().await(WAIT_TIME_SEC, TimeUnit.SECONDS);

		assertThat(testReceiver.getCountDownLatch().getCount()).isEqualTo(0);
	}
}
