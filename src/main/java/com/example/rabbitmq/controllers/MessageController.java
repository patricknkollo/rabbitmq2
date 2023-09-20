package com.example.rabbitmq.controllers;

import com.example.rabbitmq.entities.Message;
import com.example.rabbitmq.services.MessageProducer;
import com.example.rabbitmq.services.MessageService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/api/message")
public class MessageController {

    @Autowired
    private MessageService service;

    @Autowired
    private MessageProducer producer;

    @Autowired
    private RabbitTemplate template;

    @ResponseBody
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Message>> getAllMessage(){
        return service.getAllMessage();
    }


    //@RequestMapping(path = "/publish", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(path = "/publish", method = RequestMethod.POST)
    public ResponseEntity< String> publishMessage(@RequestBody Message message) {
        return producer.publishMessage(message);
    }

    @RequestMapping(path = "/publish/text", method = RequestMethod.POST)
    public ResponseEntity< String> publishTextMessage(@RequestBody String message) {
        return producer.publishTextMessage(message);
    }

    @RequestMapping(path = "/publish/xml", method = RequestMethod.POST)
    public ResponseEntity< String> publishXMLMessage(@RequestBody Message message) {
        return producer.publishXMLMessage(message);
    }

  /*  @RequestMapping(path = "/publish/xml", method = RequestMethod.POST)
    public ResponseEntity< String> publishXMLMessage(@RequestBody Message message) {
        return producer.publishXMLMessage(message);
    }*/
}
