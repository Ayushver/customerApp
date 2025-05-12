package com.kafka.config;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.kafka.constant.AppConstant;
import com.kafka.entity.Order;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class kafkaConfig {

    @Bean
   public ProducerFactory<String, Order> producerFactory(){
        Map<String,Object> kafkaProps = new HashMap<>();

       kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstant.KAFKA_HOST);
       kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
       kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
      return new DefaultKafkaProducerFactory<>(kafkaProps);
    }

    @Bean
    public KafkaTemplate<String,Order> KafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }



}
