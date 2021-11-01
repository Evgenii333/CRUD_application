package com.example.test_prodject_for_farzoom.repository;

import com.example.test_prodject_for_farzoom.models.Task;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public interface TaskRepository {

    boolean createTask(Task task);
    Task getTaskById(Long id);
    boolean updateTask(Task task);
    boolean deleteTask(long id);
    List<Task> getAllTaskSort();



}
