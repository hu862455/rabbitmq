package com.example.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Class_name: TopicRabbitConfig
 * @Exception: 
 * @Describe: 根据Routing key来分发到不同的队列中 通配符模式
 * @Author: shuaihu2
 * @Creat_date: 2019/3/29 16:08
 **/
@Configuration
public class TopicRabbitConfig {

    final static String message = "topic.message";
    final static String messages = "topic.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.messages);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        // 设置Routing key为topic.message，即该队列只接受topic.message的消息
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        // 设置Routing key为topic.# ,即该队列接受
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
