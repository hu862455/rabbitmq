package com.example.rabbitmq;

import com.example.rabbitmq.producer.fanout.FanoutSender;
import com.example.rabbitmq.producer.object.ObjectSender;
import com.example.rabbitmq.producer.topic.TopicSender;
import com.example.rabbitmq.vo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    TopicSender TopicSender;

    @Autowired
    ObjectSender ObjectSender;

    @Autowired
    FanoutSender FanoutSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendMsg(){
//        for (int i = 0; i < 100; i++) {
//            TopicSender.send();
//        }
        for (int i = 0; i < 100; i++) {
            TopicSender.send2();
        }
//        for (int i = 0; i < 100; i++) {
//            TopicSender.send1();
//        }
    }

    @Test
    public void sendObject(){
        Student student = new Student();
        student.setName("hushuai");
        student.setId("1");
        student.setSchoolName("希望小学");
        ObjectSender.send(student);
    }

    @Test
    public void sendFanMsg(){
        MessageProperties messageProperties = new MessageProperties();
        //设置消息是否持久化。Persistent表示持久化，Non-persistent表示不持久化
        messageProperties.setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
        messageProperties.setContentType("UTF-8");

        Message message = new Message("hello,rabbit_directTest!".getBytes(), messageProperties);

        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        for (int i = 0; i < 10000; i++) {
            FanoutSender.send_callback("",message,correlationData);
        }
    }
}
