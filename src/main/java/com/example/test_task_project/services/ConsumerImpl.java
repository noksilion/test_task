package com.example.test_task_project.services;

import com.example.test_task_project.model.AcceptIntegerModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ConsumerImpl implements Consumer {

    private static final Logger logger = LogManager.getLogger(ConsumerImpl.class);

    private List<AcceptIntegerModel> acceptedIntegers = new LinkedList<>();

    private final DecimalFormat decimalFormat = new DecimalFormat("#.###");

    @Override
    public void accept(int number) {
        logger.info("Accepted :" + number);

        acceptedIntegers.add(new AcceptIntegerModel(number,new Date()));
    }

    @Override
    public Double mean() {
        //deletes values accepted before 5 minutes
        deleteOldAcceptedValues();

        Double average = calculateAverageValue(acceptedIntegers);

        logger.info("Average value of ints in last 5 minutes is: {}", decimalFormat.format(average));

        return average;
    }

    private Double calculateAverageValue(List<AcceptIntegerModel> models){
        return acceptedIntegers
                .stream()
                .map(a -> (double) a.getValue() / models.size())
                .mapToDouble(f -> f)
                .sum();
    }

    private void deleteOldAcceptedValues(){
        Date now = new Date();
        Date fiveMinutesBeforeTime = get5minutesBeforeTime();

        acceptedIntegers = acceptedIntegers
                .stream()
                .filter(a -> a.getAccepted().after(fiveMinutesBeforeTime) && a.getAccepted().before(now))
                .collect(Collectors.toList());
    }

    private Date get5minutesBeforeTime(){
        Calendar currentTimeNow = Calendar.getInstance();
        currentTimeNow.add(Calendar.MINUTE, -5);
        return currentTimeNow.getTime();
    }
}
