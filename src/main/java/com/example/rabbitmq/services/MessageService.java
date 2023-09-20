package com.example.rabbitmq.services;

import com.example.rabbitmq.entities.Message;
import com.example.rabbitmq.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public ResponseEntity<List<Message>> getAllMessage(){
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }
}
