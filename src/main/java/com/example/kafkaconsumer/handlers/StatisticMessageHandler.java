package com.example.kafkaconsumer.handlers;

import com.example.kafkaconsumer.message.StatisticMicroServiceMessage;
import org.springframework.stereotype.Component;

@Component
public class StatisticMessageHandler implements MessageHandler<StatisticMicroServiceMessage> {

    @Override
    public void handle(StatisticMicroServiceMessage message) {

    }
}
