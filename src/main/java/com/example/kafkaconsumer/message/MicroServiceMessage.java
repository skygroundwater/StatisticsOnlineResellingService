package com.example.kafkaconsumer.message;

import java.io.Serializable;

public interface MicroServiceMessage extends Serializable {

    String getCommonInfo();

}
