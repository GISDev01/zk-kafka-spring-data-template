package com.gisdev01.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
// SBA adds @Configuration, @EnableAutoConfiguration, and @ComponentScan

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class KafkaApp {

	public static void main(String[] args) {

		SpringApplication.run(KafkaApp.class, args);

	}

}
