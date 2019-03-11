package com.abhi.task.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.abhi.task.model.ParentTask;
import com.abhi.task.model.Task;
import com.abhi.task.service.TaskService;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

	@Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private TaskService taskService;
        
    
    List<ParentTask> parentTaskList = new ArrayList<ParentTask>();
    List<Task> taskList = new ArrayList<Task>();
    
    Task task = new Task();
    String taskJson = "{\"taskId\":\"2\",\"parentTask\":{\"parentId\":\"1\",\"parentTask\":\"Parent Task 1\"},\"project\":{\"projectId\":\"1\",\"user\":{\"userId\":\"1\",\"firstName\":\"Abhijit\",\"lastName\":\"Marsattiwar\",\"empId\":\"am10001\"},\"projectName\":\"FMC4ME\",\"startDate\":\"2019-02-17T18:30:00.000+0000\",\"endDate\":\"2019-02-19T18:30:00.000+0000\",\"priority\":\"1\"},\"user\":{\"userId\":\"1\",\"firstName\":\"Abhijit\",\"lastName\":\"Marsattiwar\",\"empId\":\"am10001\"},\"taskName\":\"Build the code\",\"startDate\":\"2019-02-18T18:30:00.000+0000\",\"endDate\":\"2019-02-19T18:30:00.000+0000\",\"priority\":\"2\",\"isEnded\":\"0\"}";    
    
        
	@Test
	public void getAllParents() throws Exception {

		Mockito.when(
				taskService.getAllParents()).thenReturn(parentTaskList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/parentTasks").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());		
	}
	
	@Test
	public void getAllTasks() throws Exception {

		Mockito.when(
				taskService.getAllTasks()).thenReturn(taskList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/tasks").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());		
	}	
	
	@Test
	public void addTask() throws Exception {
		
		Mockito.when(
				taskService.addTask(
						Mockito.any(Task.class))).thenReturn(task);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/addTask")
				.accept(MediaType.APPLICATION_JSON).content(taskJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void updateTask() throws Exception {
		
		Mockito.when(
				taskService.updateOrCompleteTask(
						Mockito.any(Task.class))).thenReturn(task);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/api/tasks/1")
				.accept(MediaType.APPLICATION_JSON).content(taskJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}	
    
	@Test
	public void getTaskById() throws Exception {
		
		Mockito.when(
				taskService.getTaskById(
						Mockito.any(Integer.class))).thenReturn(Optional.of(task));

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/tasks/1")
				.accept(MediaType.APPLICATION_JSON).content(taskJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}
}
