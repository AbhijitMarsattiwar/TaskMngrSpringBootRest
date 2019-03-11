package com.abhi.task.service;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.abhi.task.model.Project;
import com.abhi.task.repo.ProjectRepository;


public class ProjectServiceTest {

	private ProjectService projectService;
		
	private ProjectRepository projectRepo;	
	    
    @Before
    public void setUp() {
    	projectRepo = Mockito.mock(ProjectRepository.class);    
    	projectService = new ProjectService();
    	projectService.setProjectRepo(projectRepo);
    }
    
	
	@Test 
	public void addProject() throws Exception {
		Project project = new Project();		
		projectService.addProject(project);
	}
	
        
    @Test
    public void getProjectById() throws Exception {  
    	addProject();
    	Optional<Project> project = projectService.getProjectById(123);    	
    	//assertTrue(project.isPresent());
    }
}
