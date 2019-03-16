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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.abhi.task.model.Project;
import com.abhi.task.model.User;
import com.abhi.task.service.ProjectService;
import com.abhi.task.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {

	@Autowired
    private MockMvc mockMvc;
 
    @MockBean
    private UserService userService;
    
    @MockBean
    private ProjectService projectService;               
    
    List<User> userList = new ArrayList<User>();
    List<Project> projectList = new ArrayList<Project>();
    User user1 = new User(123,"Amam","Sharma",1234);
    Project project = new Project();
    String projectJson = "{\"projectId\":\"1\",\"user\":{\"userId\":\"1\",\"firstName\":\"Abhijit\",\"lastName\":\"Marsattiwar\",\"empId\":\"10001\"},\"projectName\":\"FMC4ME\",\"startDate\":\"2019-02-17T18:30:00.000+0000\",\"endDate\":\"2019-02-19T18:30:00.000+0000\",\"priority\":\"1\"}";    
    String userJson = "{\"userId\":\"3\",\"firstName\":\"Sameer\",\"lastName\":\"Tambe\",\"empId\":\"10003\"}"; 
    //"{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
    
        
	@Test
	public void retrieveDetailsForUsers() throws Exception {

		Mockito.when(
				userService.getAllUsers()).thenReturn(userList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/users").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("*****************result******"+result.getResponse().getStatus());
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		//String expected = "{id:Course1,name:Spring,description:10 Steps}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		//JSONAssert.assertEquals(expected, result.getResponse()
				//.getContentAsString(), false);
	}
	
	@Test
	public void getAllProjects() throws Exception {

		Mockito.when(
				projectService.getAllProjects()).thenReturn(projectList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/projects").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		//System.out.println("*****************result******"+result.getResponse().getStatus());
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		//String expected = "{id:Course1,name:Spring,description:10 Steps}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		//JSONAssert.assertEquals(expected, result.getResponse()
				//.getContentAsString(), false);
	}
	
	@Test
	public void addOrUpdateUser() throws Exception {
		//Course mockCourse = new Course("1", "Smallest Number", "1",
				//Arrays.asList("1", "2", "3", "4"));

		// studentService.addCourse to respond back with mockCourse
		Mockito.when(
				userService.addOrUpdateUser(
						Mockito.any(User.class))).thenReturn(user1);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/addUser")
				.accept(MediaType.APPLICATION_JSON).content(userJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());

		//assertEquals("http://localhost/students/Student1/courses/1",
			//	response.getHeader(HttpHeaders.LOCATION));

	}
	
	@Test
	public void addProject() throws Exception {
		
		Mockito.when(
				projectService.addProject(
						Mockito.any(Project.class))).thenReturn(project);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/addProject")
				.accept(MediaType.APPLICATION_JSON).content(projectJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void updateProject() throws Exception {
		
		Mockito.when(
				projectService.updateOrCompleteProject(
						Mockito.any(Project.class))).thenReturn(project);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/api/projects/1")
				.accept(MediaType.APPLICATION_JSON).content(projectJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	
	@Test
	public void getUserById() throws Exception {
		
		Mockito.when(
				userService.getUserById(
						Mockito.any(Integer.class))).thenReturn(Optional.of(user1));

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/users/3")
				.accept(MediaType.APPLICATION_JSON).content(userJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}
    
	@Test
	public void getProjectById() throws Exception {
		
		Mockito.when(
				projectService.getProjectById(
						Mockito.any(Integer.class))).thenReturn(Optional.of(project));

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/projects/1")
				.accept(MediaType.APPLICATION_JSON).content(projectJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}
}
