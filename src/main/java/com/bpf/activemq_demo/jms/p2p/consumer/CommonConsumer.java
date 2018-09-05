package com.bpf.activemq_demo.jms.p2p.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CommonConsumer {
	
	@JmsListener(destination="common.queue")
	//实时监听对应的队列，方法中的msg如果指定类型，则可以直接拿到对应类型，如果指定的是Object，则会拿到对应类型的Message
	public void receiveMsg(String msg) {
		System.out.println("commonConsumer收到的消息为：" + msg);
	}

}
