package com.github.wz2cool.demo.localqueue.springdemo.controller;

import com.github.wz2cool.demo.localqueue.springdemo.model.request.MessageRequest;
import com.github.wz2cool.demo.localqueue.springdemo.service.ProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("test")
public class TestController {

    @Resource
    private ProducerService producerService;

    @PostMapping
    public boolean offer(@RequestBody MessageRequest request) {
        return producerService.offer(request);
    }
}
