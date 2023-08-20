package com.example.kafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.kafkaconsumer.statics.Threads.DAILY_THREAD;
import static com.example.kafkaconsumer.statics.Threads.MONTHLY_THREAD;

@SpringBootApplication
public class KafkaConsumerApplication {


    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class, args);
        DAILY_THREAD().start();
        MONTHLY_THREAD().start();
    }

}
