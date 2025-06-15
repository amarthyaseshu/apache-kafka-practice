package com.amarthya.kafkaconsumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    // group id is mandatory
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(ConsumerRecord<String, String> record){
        System.out.println("Received Message: "+ record.value());
    }

    // creating multiple consumer instances, as there can be multiple
    //partitions & heavy events, single consumer may get overloaded

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen2(ConsumerRecord<String, String> record){
        System.out.println("Received Message consumer2: "+ record.value());
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen3(ConsumerRecord<String, String> record){
        System.out.println("Received Message consumer3: "+ record.value());
    }
    // Retrying by excluding exceptions
    @RetryableTopic(attempts = "4", exclude = {NullPointerException.class, RuntimeException.class})
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen4(ConsumerRecord<String, String> record){
        System.out.println("Received Message consumer4: "+ record.value());
    }

    //Internally creates 3 tropics to handle retry
    @RetryableTopic(attempts = "4")
    // Will listen only from partition 2
    @KafkaListener(topics = "customObjTopic", groupId = "customObjGrp",
    topicPartitions = {@TopicPartition(topic = "customObjTopic",partitions = {"2"})})
    public void listenCustomObj(ConsumerRecord<String, String> record){
        System.out.println("Received Message consumer4: "+ record.value().toString());
    }

    // Dead letter topic
    @DltHandler
    public void listenCustomObjDlt(ConsumerRecord<String, String> record){
        System.out.println("Received Message consumer4: "+ record.value().toString());
    }
}


