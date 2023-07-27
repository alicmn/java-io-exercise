package com.alicmn.rabbitmqproducer.controller;

import com.alicmn.rabbitmqproducer.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @PostMapping("/message")
    public String publishMessage(
            @RequestParam("message") String message) {

        rabbitMQProducer.sendMessage(message);
        return "Message was sent successfully";
    }
}