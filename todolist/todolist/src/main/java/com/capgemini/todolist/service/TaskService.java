package com.capgemini.todolist.service;



import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.capgemini.todolist.model.Task;



public interface TaskService {

    List<Task> getAllTasks();

    void saveTask(Task task, MultipartFile file);

    void toggleStatus(Long id);

    void deleteTask(Long id);

    Task getTask(Long id);
}
