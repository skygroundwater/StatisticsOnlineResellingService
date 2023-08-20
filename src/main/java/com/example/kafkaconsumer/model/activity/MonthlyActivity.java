package com.example.kafkaconsumer.model.activity;

import com.example.kafkaconsumer.model.User;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Month;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "monthly_activity")
@NoArgsConstructor
public class MonthlyActivity extends Activity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "month")
    @Enumerated(EnumType.STRING)
    private Month month;

    @ManyToMany
    @JoinTable(name = "monthly_activities_users",
            joinColumns = {@JoinColumn(name = "monthly_activity_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> users = new HashSet<>();

}
