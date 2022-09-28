package com.cloudflash.springbootkafkaconsumerdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloudflash.springbootkafkaconsumerdemo.kafka.kafkaProducer;

@RestController
@RequestMapping("/api/kafka")
public class MessageController {
	
	private kafkaProducer kafkaProducer;

	

	    public MessageController(kafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}



		@GetMapping("/publish")
	    public ResponseEntity<String> publish(@RequestParam("message") String message){
	        kafkaProducer.sendMessage(message);
	        return ResponseEntity.ok("Message sent to kafka topic");
	    }
	

}
