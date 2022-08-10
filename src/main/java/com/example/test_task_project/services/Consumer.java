package com.example.test_task_project.services;

public interface Consumer {

    /**
     * Called periodically to consume an integer.
     */
    void accept(int number);

    /**
     * Returns the mean (aka average) of numbers consumed in the last 5 minute period.
     */
    Double mean();

}
