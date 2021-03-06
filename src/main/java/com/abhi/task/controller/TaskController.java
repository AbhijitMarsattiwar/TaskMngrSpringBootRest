package com.abhi.task.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.task.model.ParentTask;
import com.abhi.task.model.Task;
import com.abhi.task.service.TaskService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private TaskService taskService;

		
	@GetMapping("/parentTasks")
	public List<ParentTask> getAllParents() {
	    return taskService.getAllParents();
	}
	
	@GetMapping("/tasks")
	public List<Task> getAllTasks() {
	    return taskService.getAllTasks();
	}
	
	@GetMapping("/tasks/projects/{projectId}")
	public List<Task> getAllTasksForProject(@PathVariable(value = "projectId") Integer projId) {
				
	    return taskService.getAllTasksForProject(projId);
	}
	
	@PostMapping("/addTask")
	public Task addTask(@RequestBody Task task) {
		return taskService.addTask(task);
	}
		
	@PostMapping("/addParentTask")
	public ParentTask addParentTask(@RequestBody ParentTask parentTask) {
		return taskService.addTask(parentTask);
	}
	
	@GetMapping("/tasks/{id}")
	public Optional<Task> getTaskById(@PathVariable(value = "id") Integer taskId) {
	    return taskService.getTaskById(taskId);
	}
	
	@PutMapping("/tasks/{id}")
	public Task updateTask(@PathVariable(value = "id") Integer taskId,
	                                @RequestBody Task task) {
		return taskService.updateOrCompleteTask(task);
	}
	
}
