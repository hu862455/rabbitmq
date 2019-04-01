package com.example.rabbitmq.producer.fanout;

import com.rabbitmq.client.ConfirmCallback;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender implements RabbitTemplate.ConfirmCallback  {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send() {
		String context = "hi, fanout msg ";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
	}

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println("CallBackConfirm UUID: " + correlationData.getId());

		if(ack) {
			System.out.println("CallBackConfirm 消息消费成功！");
		}else {
			// 需要进行重发或者记录
			System.out.println("CallBackConfirm 消息消费失败！");

		}
		if(cause!=null) {
			System.out.println("CallBackConfirm Cause: " + cause);
		}
	}

	public void send_callback(String routingKey, Message message, CorrelationData correlationData) {
		// 使用Message作为消息体，可以不进行序列化，但是在接收端必须进行解码操作
		rabbitTemplate.setConfirmCallback(this);

		System.out.println("CallBackSender  UUID: " + correlationData.getId());

		this.rabbitTemplate.convertAndSend("fanoutExchange", routingKey , message , correlationData);
	}

}