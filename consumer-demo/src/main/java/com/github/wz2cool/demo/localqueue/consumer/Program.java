package com.github.wz2cool.demo.localqueue.consumer;

import com.github.wz2cool.localqueue.impl.SimpleConsumer;
import com.github.wz2cool.localqueue.model.config.SimpleConsumerConfig;
import com.github.wz2cool.localqueue.model.enums.ConsumeFromWhere;
import com.github.wz2cool.localqueue.model.message.QueueMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Program {

    public static void main(String[] args) throws InterruptedException {
        SimpleConsumerConfig config = new SimpleConsumerConfig.Builder()
                .setDataDir(new File("./test"))
                // 自定义保存位置文件
                .setPositionFile(new File("./test/myPosition.dat"))
                .setConsumerId("consumerId")
                // 如果没有历史位置，一般从最新位置消费，从头消费会有瞬发消息，所以默认也是ConsumeFromWhere.LAST
                .setConsumeFromWhere(ConsumeFromWhere.LAST)
                .build();


        try (SimpleConsumer consumer = new SimpleConsumer(config)) {
            while (true) {
                // 阻塞式获取
                QueueMessage message = consumer.take();
                System.out.println("[receive:]" + message.getContent());
                consumer.ack(message);
            }
        }
    }
}
