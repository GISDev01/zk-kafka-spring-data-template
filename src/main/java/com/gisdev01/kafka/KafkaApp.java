package com.gisdev01.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// SBA adds @Configuration, @EnableAutoConfiguration, and @ComponentScan
public class KafkaApplication {

	public static void main(String[] args) {

		SpringApplication.run(KafakatestApplication.class, args);

	}

}
