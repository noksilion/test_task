package com.example.test_task_project.controllers;

import com.example.test_task_project.services.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ConsumerController {

    @Autowired
    private Consumer consumer;

    private Random random = new Random();

    @Scheduled(cron = "*/5 * * * * *")
    public void callConsumerAccept(){
        consumer.accept(random.nextInt(1000));
    }

    @Scheduled(cron = "*/25 * * * * *")
    public void callConsumerMean(){
        consumer.mean();
    }
}
