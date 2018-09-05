package com.bpf.activemq_demo.jms.p2p.producer;

import javax.jms.Destination;

public interface ProducerService {

	/**
	 * @param destination 制定队列
	 * @param msg 生成的消息
	 */
	void sendMessage(Destination destination, Object msg);
	
	/**
	 * 使用默认的消息队列，发送消息
	 * @param msg 生产的消息
	 */
	void sendMessage(Object msg);
}
