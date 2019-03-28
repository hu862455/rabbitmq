package com.example.rabbitmq;

import com.example.rabbitmq.producer.MsgProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    MsgProducer MsgProducer;
    @Test
    public void contextLoads() {
    }

    @Test
    public void sendMsg(){
        for (int i = 0; i < 100; i++) {
            MsgProducer.sendMsg("发送消息，序号为："+i);
        }
    }
}
