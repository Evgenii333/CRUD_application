package com.example.test_prodject_for_farzoom.controller;


import com.example.test_prodject_for_farzoom.models.Task;
import com.example.test_prodject_for_farzoom.repository.TaskRepository;
import com.example.test_prodject_for_farzoom.repository.TaskRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class TaskController {

    private TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping(value = "/createtask")
    public ResponseEntity<?> create(@RequestBody Task task) {
        taskRepository.createTask(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/taskbyid/{id}")
    public ResponseEntity<Task> getTask(@PathVariable(name = "id") long id) {
        System.out.println(id);
        Task task = taskRepository.getTaskById(id);
        return task != null
                ? new ResponseEntity<>(task, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/taskupdate")
    public ResponseEntity<?> updateTask(@RequestBody Task task) {
        boolean update = taskRepository.updateTask(task);
        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

    }

    @DeleteMapping(value = "/deletedtask/{id}")
    public ResponseEntity<?> deletedTask(@PathVariable(name = "id") long id) {
        System.out.println(id);
        boolean deleted = taskRepository.deleteTask(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<Task>> read() {
        final List<Task> clients = taskRepository.getAllTaskSort();

        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}