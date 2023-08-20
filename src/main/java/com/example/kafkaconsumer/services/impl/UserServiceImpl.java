package com.example.kafkaconsumer.services.impl;

import com.example.kafkaconsumer.repositories.UserRepo;
import com.example.kafkaconsumer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo repository;


}
