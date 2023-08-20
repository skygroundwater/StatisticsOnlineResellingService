package com.example.kafkaconsumer.statics;

import com.example.kafkaconsumer.KafkaConsumerApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.lang.Thread.sleep;

public final class Threads {

    private static volatile LocalDateTime CURRENT_DATE_TIME = LocalDateTime.now();

    public static Thread DAILY_THREAD() {
        return new Thread(() -> {
            while (LocalDate.now().equals(CURRENT_DATE_TIME.toLocalDate())) {
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            synchronized (KafkaConsumerApplication.class) {
                CURRENT_DATE_TIME = CURRENT_DATE_TIME.plusDays(1);
            }
            DAILY_THREAD().start();
        });
    }

    public static Thread MONTHLY_THREAD() {
        return new Thread(() -> {
            while (LocalDate.now().getMonth().equals(CURRENT_DATE_TIME.getMonth())) {
                try {
                    sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            synchronized (KafkaConsumerApplication.class) {
                CURRENT_DATE_TIME = CURRENT_DATE_TIME.plusMonths(1);
            }
            MONTHLY_THREAD().start();
        });
    }


}
