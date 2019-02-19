package com.abhi.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.task.model.ParentTask;

@Repository
public interface ParentTaskRepository extends JpaRepository<ParentTask, Integer>{

}
