package com.demo.engine;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    
    private static final String TOPIC = "otel-test";
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {

        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(TOPIC, message);

        this.kafkaTemplate.send(producerRecord);
    }
}


