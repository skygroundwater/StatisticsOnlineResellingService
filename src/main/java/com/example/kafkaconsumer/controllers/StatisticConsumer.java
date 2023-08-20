package com.example.kafkaconsumer.controllers;

import com.example.kafkaconsumer.handlers.MessageHandler;
import com.example.kafkaconsumer.message.StatisticMicroServiceMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

import static com.example.kafkaconsumer.config.MessagingConfig.GROUP_ID;

@Slf4j
@EnableKafka
@RestController
@RequiredArgsConstructor
public class StatisticConsumer {

    public static final String STATISTIC_TOPIC_NAME = "online_reselling_statistic";

    private final MessageHandler<StatisticMicroServiceMessage> statisticHandler;

    @KafkaListener(
            topics = STATISTIC_TOPIC_NAME,
            groupId = GROUP_ID,
            autoStartup = "true",
            containerFactory = "kafkaListenerContainerFactory")
    public String readKafkaMessageAsync(@Payload StatisticMicroServiceMessage message) {
        statisticHandler.handle(message);
        return message.getCommonInfo();
    }

}
