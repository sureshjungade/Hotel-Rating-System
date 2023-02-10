package com.keyo.controller;

import java.util.List;

import org.apache.hc.client5.http.UserTokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.keyo.entities.User;
import com.keyo.services.UserService;

import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	Integer retrycountInteger = 1;
	
	//@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User createdUser = userService.saveUser(user);
		
		return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/{userId}")
	//@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	//@Retry(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		//System.out.println("getSingleUser method"+retrycountInteger);
		retrycountInteger++;
		User getUser = userService.getUser(userId);
		
		return new ResponseEntity<User>(getUser, HttpStatus.OK);
	}
	
	
	
	//creating fallback method for circuitbreaker
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
			System.out.println("fallback method");
			ex.printStackTrace();
			//System.out.println(ex);
		User user = User.builder().email("@gmail.com").name("dummy").about("down")
					.userId("12").build();
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/getsimplecontroller/{userId}")
	public ResponseEntity<User> getUserSimpleController(@PathVariable String userId){
		
		User getUser = userService.getUserSimplemethod(userId);
		
		return new ResponseEntity<User>(getUser, HttpStatus.OK);
	}
	
	//@PreAuthorize("hasAuthority('Admin')")
	@GetMapping("")
	public ResponseEntity<List<User>> getAllUser(){
		
		List<User> getAllUser = userService.getAllUser();
		
		return new ResponseEntity<List<User>>(getAllUser, HttpStatus.OK);
	}
	
	@PutMapping("/updateuser")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		
		return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId){
		
		return new ResponseEntity<String>(userService.deleteUser(userId), HttpStatus.OK);
	}
	
	

}
