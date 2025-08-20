package com.example.Task.service;

import com.example.Task.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {
    private Map<Long, Task> taskMap = new HashMap<>();
    private Long nextId = 1L;

    public Task createTask(Task task) {
        task.setId(nextId++);
        taskMap.put(task.getId(), task);
        return task;
    }

    public Task getTaskById(Long id) {
        return taskMap.get(id);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(taskMap.values());
    }

    public Task updateTask(Long id, Task updatedTask) {
        if (taskMap.containsKey(id)) {
            updatedTask.setId(id);
            taskMap.put(id, updatedTask);
            return updatedTask;
        }
        return null;
    }

    public boolean deleteTask(Long id) {
        return taskMap.remove(id) != null;
    }
}

