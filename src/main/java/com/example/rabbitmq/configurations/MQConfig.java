package com.example.rabbitmq.configurations;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MQConfig {

    public static final String QUEUE = "message_queue";
    public static final String EXCHANGE = "message_exchange";
    public static final String ROUTING_KEY = "message_routingKey";

    public static final String QUEUE_TEXT = "text_message_queue";
    public static final String ROUTING_KEY_TEXT = "text_message_routingKey";

    public static final String QUEUE_XML = "xml_message_queue";
    public static final String ROUTING_KEY_XML = "xml_message_routingKey";

    @Bean
    @Primary
    public Queue queue() {
        return new Queue(QUEUE);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue textQueue() {
        return new Queue(QUEUE_TEXT);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public Queue xmlQueue() {
        return new Queue(QUEUE_TEXT);
    }

    @Bean
    public Binding xmlbinding(Queue xmlqueue, DirectExchange exchange) {
        return BindingBuilder
                .bind(xmlqueue)
                .to(exchange)
                .with(ROUTING_KEY_XML);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Binding bindingExchangeWithTextQueue(Queue textQueue, DirectExchange exchange){
        return BindingBuilder
                .bind(textQueue)
                .to(exchange)
                .with(ROUTING_KEY_TEXT);
    }

   /* @Bean
    public Jackson2XmlMessageConverter xmlmessageconverter() {
        return new Jackson2XmlMessageConverter();
    }*/

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

    @Bean
    public RabbitTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

 /*  @Bean
    public RabbitTemplate templateForXML(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(xmlmessageconverter());
        return  template;
    }*/
}
