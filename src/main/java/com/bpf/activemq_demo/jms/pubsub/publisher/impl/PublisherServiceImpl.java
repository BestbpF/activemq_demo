package com.bpf.activemq_demo.jms.pubsub.publisher.impl;

import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.bpf.activemq_demo.jms.pubsub.publisher.PublisherService;

@Component
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;
    
    @Autowired
    private Topic topic;
    
    @Override
    public void publish(String msg) {
        this.jmsTemplate.convertAndSend(this.topic, msg);
    }

}
