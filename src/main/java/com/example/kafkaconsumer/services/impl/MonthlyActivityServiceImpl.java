package com.example.kafkaconsumer.services.impl;

import com.example.kafkaconsumer.repositories.MonthlyActivityRepo;
import com.example.kafkaconsumer.services.MonthlyActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MonthlyActivityServiceImpl implements MonthlyActivityService {

    private final MonthlyActivityRepo repository;

}
