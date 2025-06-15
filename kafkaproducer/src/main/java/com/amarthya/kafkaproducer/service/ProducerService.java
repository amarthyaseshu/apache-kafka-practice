package com.amarthya.kafkaproducer.service;

import com.amarthya.kafkaproducer.constants.KafkaProducerConstants;
import com.amarthya.kafkaproducer.model.Customer;
import org.apache.kafka.clients.producer.Producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

@Value("${kafka.topic.name}")
private String topicName;

   private final KafkaTemplate<String, String> kafkaTemplate;

   public ProducerService (KafkaTemplate<String, String> kafkaTemplate) {
         this.kafkaTemplate = kafkaTemplate;
    }


     public void sendMessage(String message){
          kafkaTemplate.send(KafkaProducerConstants.TOPIC_NAME, message);
        //kafkaTemplate.send(topicName, message);
      }

      // If we give partition number, then all msgs will be sent to that partition only
    public void publishRawMessage(Customer customer) {
        kafkaTemplate.send("customObjTopic",2,null, customer.toString());
    }
}