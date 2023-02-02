package com.keyo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.keyo.entities.Rating;
import com.keyo.entities.User;
import com.keyo.exception.ResourceNotFoundException;
import com.keyo.repositories.UserRepository;
import com.keyo.services.UserService;

@Service
public class UserServiceimpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired(required = true)
//	private Logger logger = LoggerFactory.getLogger(UserServiceimpl.class);
	
	@Override
	public User saveUser(User user) {
		
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		
		

		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {

		 User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Resorce not found with this userId : " + userId));
		 
		 //fetch rating of the above user from RATING SERVICE
		 
		 ArrayList<Rating> ratings = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), ArrayList.class);
		 
		// logger.info("{}",forObjectArrayList);
		 System.out.println(ratings.toString());
		 user.setRatings(ratings);
		 return user;
	
	}

	@Override
	public String deleteUser(String userId) {
		
		userRepository.deleteById(userId);
		
		return "";
	}

	@Override
	public User updateUser(String userId) {
			
		return null;
	}

}
