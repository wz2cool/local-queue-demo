package com.github.wz2cool.demo.localqueue.springdemo.service;

import com.github.wz2cool.demo.localqueue.springdemo.model.request.MessageRequest;
import com.github.wz2cool.localqueue.IProducer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProducerService {

    @Resource
    private IProducer producer;

    public boolean offer(MessageRequest request) {
        return producer.offer(request.getTag(), request.getMessageKey(), request.getContent());
    }
}
