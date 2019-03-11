package com.abhi.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.task.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
