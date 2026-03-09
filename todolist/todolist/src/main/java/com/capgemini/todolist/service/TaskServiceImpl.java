package com.capgemini.todolist.service;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.todolist.model.Task;
import com.capgemini.todolist.repository.TaskRepository;



@Service
public class TaskServiceImpl implements TaskService {

@Autowired
private TaskRepository repo;

@Override
public List<Task> getAllTasks() {
    return repo.findAll();
}

@Override
public void saveTask(Task task, MultipartFile file) {

    try {

        if(!file.isEmpty()) {
            task.setImageData(file.getBytes());
            task.setImageName(file.getOriginalFilename());
            task.setImageType(file.getContentType());
        }

        task.setStatus("PENDING");

        repo.save(task);

    } catch(IOException e) {
        e.printStackTrace();
    }

}

@Override
public void toggleStatus(Long id) {

    Task task = repo.findById(id).orElse(null);

    if(task.getStatus().equals("PENDING"))
        task.setStatus("COMPLETE");
    else
        task.setStatus("PENDING");

    repo.save(task);
}

@Override
public void deleteTask(Long id) {
    repo.deleteById(id);
}

@Override
public Task getTask(Long id) {
    return repo.findById(id).orElse(null);
}

}
