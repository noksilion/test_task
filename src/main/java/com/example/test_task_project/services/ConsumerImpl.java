package com.example.test_task_project.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsumerImpl implements Consumer {

    private static final Logger logger = LogManager.getLogger(ConsumerImpl.class);

    private List<Integer> acceptedIntegers = new ArrayList<>();

    @Override
    public void accept(int number) {
        logger.info("Accepted :" + number);
        acceptedIntegers.add(number);
    }

    @Override
    public Float mean() {
        List<Float> collect = acceptedIntegers
                .stream()
                .map(a -> (float) a / acceptedIntegers.size())
                .collect(Collectors.toList());

        float average = 0F;
        for (Float f : collect) {
            average = Float.sum(average, f);
        }

        //clear all values
        acceptedIntegers = new ArrayList<>();

        logger.info("Average value of ints in last 5 minutes is: " + average);

        return average;
    }
}
