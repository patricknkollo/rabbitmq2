package com.example.rabbitmq.services;

import com.example.rabbitmq.configurations.MQConfig;
import com.example.rabbitmq.entities.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MessageProducer {

    @Autowired
    private RabbitTemplate template;

    public ResponseEntity< String> publishMessage(@RequestBody Message message) {
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);

        return new ResponseEntity<>("Message Published", HttpStatus.OK);
    }

    public ResponseEntity< String> publishTextMessage(@RequestBody String message) {
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY_TEXT, message);

        return new ResponseEntity<>("Message Published", HttpStatus.OK);
    }

    public ResponseEntity< String> publishXMLMessage(@RequestBody Message message) {
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY_XML, message);

        return new ResponseEntity<>("Message Published", HttpStatus.OK);
    }

  /*  public ResponseEntity< String> publishXMLMessage(@RequestBody Message message) {
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, message);

        return new ResponseEntity<>("Message Published", HttpStatus.OK);
    }*/
}
