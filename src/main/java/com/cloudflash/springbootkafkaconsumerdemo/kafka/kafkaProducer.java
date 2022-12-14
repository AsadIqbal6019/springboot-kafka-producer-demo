package com.cloudflash.springbootkafkaconsumerdemo.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaProducer {
	
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

	public kafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String message) {
		
		LOGGER.info(String.format("Message sent -> %s", message));
		kafkaTemplate.send("cloudflash", message);	
		
	}
	

	
	

}
