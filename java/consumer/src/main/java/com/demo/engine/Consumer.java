package com.demo.engine;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Header;
import org.springframework.stereotype.Service;

@Service
public class Consumer {  
 
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "otel-test", groupId = "otel_group_consumer")
    public void consume(ConsumerRecord<String, String> consumerRecord) throws IOException {
        String message = consumerRecord.value();
        logger.info(String.format("#### -> Consumed message -> %s with headers", message));

        logger.info("- - - - - - - - - - - - - - -");
        logger.info("received message='{}'", message);
    }
}
