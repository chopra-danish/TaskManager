package com.spring.taskapi.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.taskapi.repository.TaskRepository;
import com.spring.taskapi.model.Task;
import com.spring.taskapi.exception.*;


@Service
public class TaskService {
    
    @Autowired
    private TaskRepository taskRepository;

    public Task insert(Task task)
    {
        return taskRepository.save(task);
    }
    public List <Task> getAllTask()
    {
        return taskRepository.findAll();
    }
    public Task validate(int id)
    {
        Optional<Task> optional=taskRepository.findById(id);

        return optional.get();
    }
    public List<Task> validate(String title) {
        return taskRepository.findByTitle(title);
    }
    
    /*public Task validate(String title)
    {
        Optional<Task> optional=taskRepository.findByTitle(title);
        return optional.get();
    } */
    
    
    public void deleteTaskById(int id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        taskRepository.delete(task);
    }

    // Update an existing task
    public Task updateTask(int id, Task newTask) {
        Task task = taskRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
                
        task.setTitle(newTask.getTitle());
        task.setDescription(newTask.getDescription());
        task.setDue_date(newTask.getDue_Date());
        task.setPriority(newTask.getPriority());
        task.setStatues(newTask.getStatus());

        return taskRepository.save(task);
    }
}
