package com.bpf.activemq_demo.controller;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bpf.activemq_demo.domain.Order;
import com.bpf.activemq_demo.jms.p2p.producer.ProducerService;


@RestController
@RequestMapping("/jms/p2p")
public class P2pController {

	@Autowired
	private ProducerService producer;
	
	@GetMapping("order/strMsg")
	public Object order(String msg) {
		Queue orderQueue = new ActiveMQQueue("order.queue");
		producer.sendMessage(orderQueue, msg);
		return "success";
	}
	
	@GetMapping("order/objMsg")
	public Object order(Order order) {
		Queue orderQueue = new ActiveMQQueue("order.queue");
		//在发送实体对象时，该对象需要序列化，可以使用序列化工具，或者直接继承Serializable，但该方式性能低
		//使用json转换工具如springboot自带的jackson，将对象转换为字符串进行发送，消费时再转为实体类也是不错的选择
		producer.sendMessage(orderQueue, order);
		return "success";
	}
	
	@GetMapping("common")
	public Object common(String msg) {
		producer.sendMessage(msg);
		return "success";
	}
}
