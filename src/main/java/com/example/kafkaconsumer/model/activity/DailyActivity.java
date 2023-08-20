package com.example.kafkaconsumer.model.activity;

import com.example.kafkaconsumer.model.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "daily_activity")
@NoArgsConstructor
public class DailyActivity extends Activity {

    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToMany
    @JoinTable(name = "daily_activities_users",
            joinColumns = {@JoinColumn(name = "daily_activity_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> users = new HashSet<>();

}
