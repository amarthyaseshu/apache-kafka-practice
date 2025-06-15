package com.amarthya.kafkaproducer.config;

import com.amarthya.kafkaproducer.constants.KafkaProducerConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
Create topic programatically in SB
 */
@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic createNewTopic(){

        return new NewTopic(KafkaProducerConstants.TOPIC_NAME,3,(short)1);

    }

    // we can also define serialization, deserialization, certificates in config instead of app.properties
}
