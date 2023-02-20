package com.bngferoz.messagebroker.controller;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bngferoz.messagebroker.config.MQConfig;
import com.bngferoz.messagebroker.dto.request.MessageRequestDto;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "1. MQ Controller", description = "MQ Related APIs")
public class MQController {

	@Autowired
	private RabbitTemplate template;
	
	@Tag(name = "mq001", description = "MQ Test")
	@PostMapping("/publish")
	public boolean publishMessage(@RequestBody MessageRequestDto msg) {
		msg.setMessageId(UUID.randomUUID().toString());
		msg.setTimeStamp(LocalDateTime.now());
		template.convertAndSend(MQConfig.exchangeName,
				MQConfig.routingKey, msg);
		return true;
		
	}
}
