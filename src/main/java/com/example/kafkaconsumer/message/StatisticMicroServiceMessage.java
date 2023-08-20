package com.example.kafkaconsumer.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Data
@Slf4j
@EqualsAndHashCode
public class StatisticMicroServiceMessage implements MicroServiceMessage {

    private Long messageId;

    private NestedUserInfo userInfo;

    private LocalDateTime timeSending;

    private transient String fromServiceName;

    private transient String toServiceName;

    @Override
    public String getCommonInfo() {
        return String.format("%s message id : %s, user : %s, from : %s to : %s",
                getClass().getSimpleName(), messageId,
                userInfo, fromServiceName, toServiceName);
    }
}