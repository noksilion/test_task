package com.example.test_task_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestTaskProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestTaskProjectApplication.class, args);
	}

}
