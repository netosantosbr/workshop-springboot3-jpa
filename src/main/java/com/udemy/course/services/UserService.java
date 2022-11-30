package com.udemy.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.course.entities.User;
import com.udemy.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		return repository.findById(id).get();
	}
	
	public User insert(User user) {
		 return repository.save(user);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User user) {
		User entity = repository.getReferenceById(id);
		updateData(entity, user);
		return repository.save(entity);
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getEmail());
		entity.setEmail(user.getEmail());
		entity.setPhone(entity.getPhone());
	}
}
