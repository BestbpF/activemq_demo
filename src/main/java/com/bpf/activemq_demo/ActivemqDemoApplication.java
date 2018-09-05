package com.bpf.activemq_demo;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@SpringBootApplication
@EnableJms
public class ActivemqDemoApplication {
	
	@Bean
	//创建默认的Queue，方便后面直接注入使用
	public Queue defaultQueue() {
		return new ActiveMQQueue("common.queue");
	}
	
	@Bean
	//创建默认的Topic，方便后面直接注入使用
	public Topic defaultTopic() {
	    return new ActiveMQTopic("video.topic");
	}

	@Bean
	//添加该配置可使p2p和pubsub两中模式共存
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
	public static void main(String[] args) {
		SpringApplication.run(ActivemqDemoApplication.class, args);
	}
}
