package com.example.rabbitmq.consumer.fanout;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component

public class FanoutReceiverA {

    @RabbitHandler
    @RabbitListener(queues = "fanout.A")
    public void process(Message message) throws UnsupportedEncodingException {
        MessageProperties messageProperties = message.getMessageProperties();
        String contentType = messageProperties.getContentType();

        System.out.println("fanout Receiver A  :"+new String(message.getBody(), contentType));

//        System.out.println("fanout Receiver A  : " + message);
    }

}
