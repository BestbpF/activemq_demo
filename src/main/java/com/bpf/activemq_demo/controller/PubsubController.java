package com.bpf.activemq_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bpf.activemq_demo.jms.pubsub.publisher.PublisherService;

@RestController
@RequestMapping("/jms/pubsub")
public class PubsubController {
    
    @Autowired
    private PublisherService publisherService;
    
    @GetMapping("video")
    public Object publish(String msg) {
        publisherService.publish(msg);
        return "success";
    }

}
