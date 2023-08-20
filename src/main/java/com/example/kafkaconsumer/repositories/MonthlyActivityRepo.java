package com.example.kafkaconsumer.repositories;

import com.example.kafkaconsumer.model.activity.MonthlyActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyActivityRepo extends JpaRepository<Integer, MonthlyActivity> {
}
