package com.example.test_task_project.scheduler;

import com.example.test_task_project.services.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ConsumerScheduler {

    @Autowired
    private Consumer consumer;

    private final Integer RANDOM_BOUND = 1000;

    private final Random random = new Random();

    /**
     * Schedules task which calls every 5 seconds
     * @see com.example.test_task_project.services.Consumer#accept
     * with random int value
     *
     * @author noksilion
     */
    @Scheduled(cron = "*/5 * * * * *")
    public void callConsumerAccept() {
        consumer.accept(random.nextInt(RANDOM_BOUND));
    }

    /**
     * Schedules task which calls every 5 minutes
     * @see com.example.test_task_project.services.Consumer#mean
     *
     * @author noksilion
     */
    @Scheduled(cron = "0 */5 * * * *")
    public void callConsumerMean() {
        consumer.mean();
    }
}
