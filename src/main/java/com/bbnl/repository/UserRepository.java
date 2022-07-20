package com.bbnl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bbnl.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	@Query("select u from User u where u.emailId = :id")
	public User getUserByUserId(@Param("id") String id);
}
