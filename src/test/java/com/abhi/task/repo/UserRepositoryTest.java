package com.abhi.task.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.abhi.task.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	private TestEntityManager entityManager;
 
    @Autowired
    private UserRepository userRepository;
           
    @Before
    public void setUp() {
    	entityManager = Mockito.mock(TestEntityManager.class);    	
    }
    
    @Test
    public void whenGetAllUsers_thenReturnUsers() {        
        // when
    	List<User> userList = userRepository.findAll();     
        // then
        assertThat(userList).isNotEmpty();
        //System.out.println("***********Inside ********"+userList.size());
    }
}
