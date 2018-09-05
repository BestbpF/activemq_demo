package com.bpf.activemq_demo.jms.pubsub.subscriber;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicSubscriber1 {

    @JmsListener(destination="video.topic", containerFactory="jmsListenerContainerTopic")
    //添加启动类中配置的containerFactory，开启pubsub模式，且可以与p2p模式共存
    public void receive(String msg) {
        System.out.println("TopicSubscriber1接收到消息：" + msg);
    }
}
