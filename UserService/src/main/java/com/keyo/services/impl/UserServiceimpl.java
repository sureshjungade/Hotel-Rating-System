package com.keyo.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.keyo.entities.Hotel;
import com.keyo.entities.Rating;
import com.keyo.entities.User;
import com.keyo.exception.ResourceNotFoundException;
import com.keyo.externalservices.IHotelService;
import com.keyo.repositories.UserRepository;
import com.keyo.services.UserService;

@Service
public class UserServiceimpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IHotelService hotelService;
	
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
		 System.out.println("getUser");
		 Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		 
		 List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		 
		// logger.info("{}",forObjectArrayList);
		 System.out.println(ratingsOfUser.toString());
		 
		 List<Rating> ratingList = ratings.stream().map(rating -> {
			 
			 //api call to hotel service to get the hotel
			 
			 //ResponseEntity<Hotel> HotelEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/getHotel/"+rating.getHotelId(), Hotel.class);
			 
			  Hotel hotel = hotelService.getHotel(rating.getHotelId()); // HotelEntity.getBody();
			 //set the hotel to rating
			 //return rating
			  rating.setHotel(hotel);
			 return rating;
		 }).collect(Collectors.toList());
		 
		 user.setRatings(ratingList);
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
