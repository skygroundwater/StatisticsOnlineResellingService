package com.example.kafkaconsumer.model;

import com.example.kafkaconsumer.model.activity.DailyActivity;
import com.example.kafkaconsumer.model.activity.MonthlyActivity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@EqualsAndHashCode
@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_last_visit")
    private LocalDateTime dateTime;

    @ManyToMany
    @JoinTable(name = "daily_activities_users",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "daily_activity_id")})
    private Set<DailyActivity> dailyActivities;

    @ManyToMany
    @JoinTable(name = "monthly_activities_users",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "monthly_activity_id")})
    private Set<MonthlyActivity> monthlyActivities;
}
