package com.abhi.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.task.model.ParentTask;
import com.abhi.task.model.Project;
import com.abhi.task.model.Task;
import com.abhi.task.model.User;
import com.abhi.task.repo.ParentTaskRepository;
import com.abhi.task.repo.ProjectRepository;
import com.abhi.task.repo.TaskRepository;
import com.abhi.task.repo.UserRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepo;	
	
	@Autowired
	private UserRepository userRepo;
	
	public List<Project> getAllProjects() {
		
		List<Project> projectList = projectRepo.findAll();				
		return projectList;
	}
		
	public Project addProject(Project project) {
		return projectRepo.save(project);
	}
	
	public Project updateOrCompleteProject(Project project) {
		return projectRepo.save(project);
	}
	
	public Optional<Project> getProjectById(Integer projectId) {
		 Optional<Project> project = projectRepo.findById(projectId);		 
		 return project;
	}

	public ProjectRepository getProjectRepo() {
		return projectRepo;
	}

	public void setProjectRepo(ProjectRepository projectRepo) {
		this.projectRepo = projectRepo;
	}

	
}
