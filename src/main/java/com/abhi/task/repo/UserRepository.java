package com.abhi.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.task.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
