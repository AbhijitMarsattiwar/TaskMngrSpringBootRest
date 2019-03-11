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

import com.abhi.task.model.Task;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskRepositoryTest {

	private TestEntityManager entityManager;
 
    @Autowired
    private TaskRepository taskRepository;
           
    @Before
    public void setUp() {
    	entityManager = Mockito.mock(TestEntityManager.class);    	
    }
    
    @Test
    public void whenGetAllTasks_thenReturnTasks() {        
        // when
    	List<Task> taskList = taskRepository.findAll();     
        // then
        assertThat(taskList).isNotEmpty();
        //System.out.println("***********Inside ********"+userList.size());
    }
}
