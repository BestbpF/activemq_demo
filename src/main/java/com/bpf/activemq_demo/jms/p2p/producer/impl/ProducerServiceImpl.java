package com.bpf.activemq_demo.jms.p2p.producer.impl;

import javax.jms.Destination;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.bpf.activemq_demo.jms.p2p.producer.ProducerService;



@Component
public class ProducerServiceImpl implements ProducerService {
	
	@Autowired
	private Queue queue;
	
	@Autowired
	private JmsMessagingTemplate jmsTemplate; //发送消息工具

	@Override
	public void sendMessage(Destination destination, Object msg) {
		jmsTemplate.convertAndSend(destination, msg);
	}

	@Override
	public void sendMessage(Object msg) {
		jmsTemplate.convertAndSend(this.queue, msg);		
	}

}
