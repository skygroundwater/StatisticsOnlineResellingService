package com.example.kafkaconsumer.model.activity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode
@MappedSuperclass
@Data
public abstract class Activity {

    @Column(name = "count_of_users")
    private Integer countOfUsers;

    @Column(name = "date")
    private LocalDate date;

}
