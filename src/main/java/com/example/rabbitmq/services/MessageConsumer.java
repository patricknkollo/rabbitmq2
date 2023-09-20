/*
package com.example.rabbitmq.controllers;

import com.example.rabbitmq.configurations.MQConfig;
import com.example.rabbitmq.entities.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReader {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(Message message) {
        System.out.println(message);
    }

     @RabbitListener(queues = MQConfig.QUEUE_TEXT)
    public void textListener(Message message) {
        System.out.println(message);
    }

     @RabbitListener(queues = MQConfig.QUEUE_XML)
    public void xmlListener(Message message) {
        System.out.println(message);
    }
}
*/
