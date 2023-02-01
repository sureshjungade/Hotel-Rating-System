package com.keyo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keyo.entities.User;
import com.keyo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User createdUser = userService.saveUser(user);
		
		return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		
		User getUser = userService.getUser(userId);
		
		return new ResponseEntity<User>(getUser, HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUser(){
		
		List<User> getAllUser = userService.getAllUser();
		
		return new ResponseEntity<List<User>>(getAllUser, HttpStatus.OK);
	}

}
