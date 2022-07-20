package com.bbnl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbnl.entity.User;
import com.bbnl.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> listAllUser() {
		return repo.findAll();
	}
	
	public void saveUser(User user) {
		repo.save(user);
	}
	
	public void deleteUser(String id) {
		repo.deleteById(id);
	}
}
