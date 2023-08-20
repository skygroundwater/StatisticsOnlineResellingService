package com.example.kafkaconsumer.repositories;

import com.example.kafkaconsumer.model.activity.DailyActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyActivityRepo extends JpaRepository<Integer, DailyActivity> {
}
