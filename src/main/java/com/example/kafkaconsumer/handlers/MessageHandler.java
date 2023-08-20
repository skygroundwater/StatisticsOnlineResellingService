package com.example.kafkaconsumer.handlers;

import com.example.kafkaconsumer.message.MicroServiceMessage;

public interface MessageHandler<T extends MicroServiceMessage> {

    void handle(T message);

}
