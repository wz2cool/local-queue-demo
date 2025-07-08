package com.github.wz2cool.demo.localqueue.springdemo.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wz2coo.localqueue.spring.annotation.LocalQueueMessageListener;
import com.github.wz2coo.localqueue.spring.core.LocalQueueListener;
import com.github.wz2cool.localqueue.model.message.QueueMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@LocalQueueMessageListener(customerId = "rtd_consumer", selectorTag = "rtd", maxBatchSize = 10)
public class RtdListener implements LocalQueueListener {
    @Override
    public void onMessages(List<QueueMessage> list) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(list);
            System.out.println("[rtd] receive msg: " + s);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
