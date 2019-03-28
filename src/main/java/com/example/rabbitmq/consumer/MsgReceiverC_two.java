package com.example.rabbitmq.consumer;

import com.example.rabbitmq.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Package_name: com.example.rabbitmq.consumer
 * @Class_name: $CLASS_NAME$
 * @Exception: $Exception$
 * @Describe: TODO
 * @Author: shuaihu2
 * @Creat_date: 2019 2019/3/28 17:50
 **/
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiverC_two {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RabbitHandler
    public void process(String content) {
        logger.info("处理器two接收处理队列A当中的消息： " + content);
    }

}
