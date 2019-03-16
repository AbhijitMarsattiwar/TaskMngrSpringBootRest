package com.abhi.task.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.task.model.Project;
import com.abhi.task.model.User;
import com.abhi.task.service.ProjectService;
import com.abhi.task.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	
	@GetMapping("/projects")
	public List<Project> getAllProjects() {
	    return projectService.getAllProjects();
	}
		
	@PostMapping("/addProject")
	public Project addProject(@RequestBody Project project) {
		return projectService.addProject(project);
	}
	
	@PutMapping("/projects/{id}")
	public Project updateProject(@PathVariable(value = "id") Integer taskId,
	                                @RequestBody Project project) {
		return projectService.updateOrCompleteProject(project);
	}
	
	@GetMapping("/projects/{id}")
	public Optional<Project> getProjectById(@PathVariable(value = "id") Integer projectId) {
	    return projectService.getProjectById(projectId);
	}	

	@GetMapping("/users")
	public List<User> getAllUsers() {
	    return userService.getAllUsers();
	}
	
	@PostMapping("/addUser")
	public User addOrUpdateUser(@RequestBody User user) {
		return userService.addOrUpdateUser(user);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userService.addOrUpdateUser(user);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable(value = "userId") Integer userId) {
		userService.deleteUser(userId);
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable(value = "id") Integer userId) {
	    return userService.getUserById(userId);
	}
}
