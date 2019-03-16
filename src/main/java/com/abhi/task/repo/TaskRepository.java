package com.abhi.task.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abhi.task.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

	@Query(value="select task from Task task where project_id = ?1 ")
	public List<Task> findAllTasksForProject(Integer projectId);
}
