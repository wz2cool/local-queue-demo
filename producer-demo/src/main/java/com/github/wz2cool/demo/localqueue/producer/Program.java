package com.github.wz2cool.demo.localqueue.producer;

import com.github.wz2cool.localqueue.impl.SimpleProducer;
import com.github.wz2cool.localqueue.model.config.SimpleProducerConfig;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {

    public static void main(String[] args) {
        SimpleProducerConfig config = new SimpleProducerConfig.Builder()
                .setDataDir(new File("./test"))
                // 保留7天数据
                .setKeepDays(7)
                .build();

        try (SimpleProducer producer = new SimpleProducer(config)) {
            while (true) {
                String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                String message = "Produce message at: " + formattedDateTime;
                producer.offer(message);
            }
        }
    }
}
