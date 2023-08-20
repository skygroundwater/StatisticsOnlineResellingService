package com.example.kafkaconsumer.services.impl;

import com.example.kafkaconsumer.repositories.DailyActivityRepo;
import com.example.kafkaconsumer.services.DailyActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DailyActivityServiceImpl implements DailyActivityService {

    private final DailyActivityRepo repository;

}
