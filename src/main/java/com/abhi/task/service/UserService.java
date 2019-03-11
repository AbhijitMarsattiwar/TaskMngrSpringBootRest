package com.abhi.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.task.model.ParentTask;
import com.abhi.task.model.Task;
import com.abhi.task.model.User;
import com.abhi.task.repo.ParentTaskRepository;
import com.abhi.task.repo.ProjectRepository;
import com.abhi.task.repo.TaskRepository;
import com.abhi.task.repo.UserRepository;

@Service
public class UserService {
	
		
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
		
	public User addOrUpdateUser(User user) {
		return userRepo.save(user);
	}
		
	public Optional<User> getUserById(Integer userId) {
		 Optional<User> user = userRepo.findById(userId);		 
		 return user;
	}
	
	public void deleteUser(User user) {
		userRepo.delete(user);
	}

	public UserRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	
}
