package com.github.wz2cool.demo.localqueue.consumer;

import com.github.wz2cool.localqueue.impl.SimpleConsumer;
import com.github.wz2cool.localqueue.model.config.SimpleConsumerConfig;
import com.github.wz2cool.localqueue.model.message.QueueMessage;

import java.io.File;

public class Program {

    public static void main(String[] args) throws InterruptedException {
        SimpleConsumerConfig config = new SimpleConsumerConfig.Builder()
                .setDataDir(new File("./test"))
                .setConsumerId("consumerId")
                .build();

        try (SimpleConsumer consumer = new SimpleConsumer(config)) {
            while (true) {
                QueueMessage message = consumer.take();
                System.out.println(message.getContent());
                consumer.ack(message);
            }
        }
    }
}
