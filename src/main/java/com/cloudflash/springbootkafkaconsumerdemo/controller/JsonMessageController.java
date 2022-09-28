package com.cloudflash.springbootkafkaconsumerdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudflash.springbootkafkaconsumerdemo.kafka.JsonKafkaProducer;
import com.cloudflash.springbootkafkaconsumerdemo.model.User;

@RestController
@RequestMapping("/api/kafka")
public class JsonMessageController {
	
	   private JsonKafkaProducer kafkaProducer;

	    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
	        this.kafkaProducer = kafkaProducer;
	    }

	    @PostMapping("/publish")
	    public ResponseEntity<String> publish(@RequestBody User user){
	        kafkaProducer.sendMessage(user);
	        return ResponseEntity.ok("Json message sent to kafka topic");
	    }
	

}
