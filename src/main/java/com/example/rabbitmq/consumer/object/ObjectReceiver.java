package com.example.rabbitmq.consumer.object;

import com.example.rabbitmq.vo.Student;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

    @RabbitHandler
    public void process(Student user) {
        System.out.println("Receiver object : " + user);
    }

}
