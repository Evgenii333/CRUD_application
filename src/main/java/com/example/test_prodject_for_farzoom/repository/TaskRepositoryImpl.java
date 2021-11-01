package com.example.test_prodject_for_farzoom.repository;

import com.example.test_prodject_for_farzoom.models.Task;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class TaskRepositoryImpl implements TaskRepository {

    private static final List<Task> TASK_STORAGE = new CopyOnWriteArrayList<>();
    private static final AtomicLong TASK_ID = new AtomicLong();

    public void str(){
        System.out.println(TASK_STORAGE);
    }


    @Override
    public boolean createTask(Task task) {
        final Long taskId = TASK_ID.incrementAndGet();
        task.setId(taskId);
        return TASK_STORAGE.add(task);
    }

   // @Override
   // public boolean createTask(Task task) {
    //    return TASK_STORAGE.add(task);
   // }

    @Override
    public Task getTaskById(Long id) {

        return getById(id);
    }

    @Override
    public boolean updateTask(Task task) {
        Task updateTask = getById(task.getId());
        updateTask.setName(task.getName());
        updateTask.setDescription(task.getDescription());
        updateTask.setDate(task.getDate());
        return true;
    }

    @Override
    public boolean deleteTask(long id) {
        return TASK_STORAGE.remove(getById(id));
    }

    @Override
    public List<Task> getAllTaskSort() {
        return TASK_STORAGE.stream().sorted(Comparator.comparing(Task::getDate)).collect(Collectors.toList());
    }

    private Task getById(Long id){
        return TASK_STORAGE.stream().filter( x-> x.getId().equals(id)).findAny().orElseThrow();

    }
}
