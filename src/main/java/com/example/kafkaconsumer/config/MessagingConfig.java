package com.example.kafkaconsumer.config;

import com.example.kafkaconsumer.message.StatisticMicroServiceMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
@EnableKafka
public class MessagingConfig {

    private static final String BOOTSTRAP_SERVER = "127.0.0.1:9092";

    public static final String GROUP_ID = "statistic_group";


    @Bean
    public ConsumerFactory<String, StatisticMicroServiceMessage> consumerFactory() {
        Map<String, Object> config = new HashMap<>();

        JsonDeserializer<StatisticMicroServiceMessage> deserializer =
                new JsonDeserializer<>(StatisticMicroServiceMessage.class);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);
        deserializer.setRemoveTypeHeaders(false);

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                BOOTSTRAP_SERVER);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                deserializer);
        config.put(ConsumerConfig.GROUP_ID_CONFIG,
                GROUP_ID);/*
        config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        config.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1000);*/
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, StatisticMicroServiceMessage> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, StatisticMicroServiceMessage> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
