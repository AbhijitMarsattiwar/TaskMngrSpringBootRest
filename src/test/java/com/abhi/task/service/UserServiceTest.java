package com.abhi.task.service;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.abhi.task.model.User;
import com.abhi.task.repo.UserRepository;


public class UserServiceTest {

	private UserService userService;
		
	private UserRepository userRepository;
	    
    @Before
    public void setUp() {
    	//entityManager = Mockito.mock(TestEntityManager.class);    	
    	userRepository = Mockito.mock(UserRepository.class);    
    	userService = new UserService();
    	userService.setUserRepo(userRepository);
    }
    
	
	@Test 
	public void addOrUpdateUser() throws Exception {
		
		User user = new User();
		user.setUserId(123);
		user.setFirstName("Aparna");
		user.setLastName("Koli");
		userService.addOrUpdateUser(user);
	}
	
        
    @Test
    public void test_getUserById() throws Exception {  
    	addOrUpdateUser();
    	Optional<User> user = userService.getUserById(123);
    	//assertTrue(user.isPresent());
    	//assertEquals(user.isPresent(), actual);
    }
}
