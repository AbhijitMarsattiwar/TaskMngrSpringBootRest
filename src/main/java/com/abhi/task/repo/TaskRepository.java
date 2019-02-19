package com.abhi.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.task.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
