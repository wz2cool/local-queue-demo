package com.github.wz2cool.demo.localqueue.consumer.demo;

import com.github.wz2cool.localqueue.impl.SimpleQueue;
import com.github.wz2cool.localqueue.model.config.SimpleQueueConfig;

import java.io.File;

public class Demo1 {

    public static void run() {
        SimpleQueueConfig config = new SimpleQueueConfig.Builder()
                .setDataDir(new File("./test"))
                .setKeepDays(1)
                .build();

        try (SimpleQueue queue = new SimpleQueue(config)) {

            Thread consumer1Thread = new Thread(() -> {
                try {
                    queue.getConsumer("consumerId").take();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupted();
                }
            });


        }
    }
}
