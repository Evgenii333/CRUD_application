package com.example.test_prodject_for_farzoom;

import com.example.test_prodject_for_farzoom.models.Task;
import com.example.test_prodject_for_farzoom.repository.TaskRepository;
import com.example.test_prodject_for_farzoom.repository.TaskRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class TestProdjectForFarzoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestProdjectForFarzoomApplication.class, args);
        TaskRepositoryImpl taskRepository = new TaskRepositoryImpl();
        taskRepository.str();

    }
}
