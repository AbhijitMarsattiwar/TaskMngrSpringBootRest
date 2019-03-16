package com.abhi.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.task.model.ParentTask;
import com.abhi.task.model.Task;
import com.abhi.task.repo.ParentTaskRepository;
import com.abhi.task.repo.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private ParentTaskRepository parentRepo;	
	
	@Autowired
	private TaskRepository taskRepo;
	
	public List<ParentTask> getAllParents() {
		return parentRepo.findAll();
	}
	
	public List<Task> getAllTasksForProject(Integer projectId) {
		return taskRepo.findAllTasksForProject(projectId);
	}
	
	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}
	
	public Task addTask(Task task) {
		return taskRepo.save(task);
	}
	
	public ParentTask addTask(ParentTask task) {
		return parentRepo.save(task);
	}
	
	public Task updateOrCompleteTask(Task task) {
		return taskRepo.save(task);
	}
	
	public Optional<Task> getTaskById(Integer taskId) {
		 Optional<Task> task = taskRepo.findById(taskId);		 
		 return task;
	}
	
	public List<Task> getTaskCountForProject(Iterable<Integer> projectId) {
		 List<Task> taskList = taskRepo.findAllById(projectId);		 
		 return taskList;
	}

}
