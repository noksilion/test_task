package com.example.test_task_project.model;


import java.util.Date;

public class AcceptIntegerModel {

    private Integer value;

    private Date accepted;

    public AcceptIntegerModel(Integer value, Date accepted) {
        this.value = value;
        this.accepted = accepted;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getAccepted() {
        return accepted;
    }

    public void setAccepted(Date accepted) {
        this.accepted = accepted;
    }
}
