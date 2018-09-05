package com.bpf.activemq_demo.jms.p2p.consumer;

import javax.jms.JMSException;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

	@JmsListener(destination="order.queue")
	//实时监听对应的队列，方法中的msg如果指定类型，则可以直接拿到对应类型，如果指定的是Object，则会拿到对应类型的Message
	//如String对应ActiveMQTextMessage，实体类对应ActiveMQObjectMessage等
	public void receiveMsg(Object msg) throws JMSException {
		
		if (msg instanceof ActiveMQTextMessage) {
			ActiveMQTextMessage textMessage = (ActiveMQTextMessage) msg;
			System.out.println("orderConsumer收到的字符串消息为：" + textMessage.getText());
		}else if (msg instanceof ActiveMQObjectMessage) {
			ActiveMQObjectMessage objectMessage = (ActiveMQObjectMessage) msg;
			System.out.println("orderConsumer收到的order对象为：" + objectMessage.getObject());
		}
	}
}
