package com.example.springCloud.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springCloud.hello.dao.UserRepository;
import com.example.springCloud.hello.entity.User;

/** 
* @author yj 
* @date 2019-03-03 
*/
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		User findOne = this.userRepository.findOne(id);
		return findOne;
	}

}
