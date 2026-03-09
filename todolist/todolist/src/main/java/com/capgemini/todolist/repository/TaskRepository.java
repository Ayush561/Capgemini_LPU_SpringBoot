package com.capgemini.todolist.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.todolist.model.Task;


public interface TaskRepository extends JpaRepository<Task, Long> {

}