package com.github.wz2cool.demo.localqueue.producer;

import com.github.wz2cool.localqueue.impl.SimpleProducer;
import com.github.wz2cool.localqueue.model.config.SimpleProducerConfig;

import java.io.File;

public class Program {

    public static void main(String[] args) throws InterruptedException {
        SimpleProducerConfig config = new SimpleProducerConfig.Builder()
                .setDataDir(new File("./test"))
                .build();

        try (SimpleProducer producer = new SimpleProducer(config)) {
            while (true) {
                String message = System.currentTimeMillis() + "message";
                producer.offer(message);
            }
        }
    }
}
