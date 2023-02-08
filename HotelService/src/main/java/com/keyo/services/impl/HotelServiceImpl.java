package com.keyo.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keyo.entities.Hotel;
import com.keyo.entities.Rating;
import com.keyo.entities.User;
import com.keyo.exception.ResourceNotFoundException;
import com.keyo.externalservices.IRatingService;
import com.keyo.externalservices.IUserService;
import com.keyo.repositories.IHotelRespository;
import com.keyo.services.IHotelServices;

@Service
public class HotelServiceImpl implements IHotelServices{

	@Autowired
	private IHotelRespository hotelRepo;
	
	@Autowired
	private IRatingService ratingService;
	
	@Autowired
	private IUserService userService;

	
	@Override
	public Hotel create(Hotel hotel) {
		
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId); 
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel get(String hotelId) {
		//System.out.println("hggg");
		
		return hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found!!"));
		
	}

	@Override
	public Hotel getCombinedData(String hotelId) {
		Hotel hotel = hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found!!"));
		List<Rating> ratings = ratingService.getRatingByHotelId(hotelId);
		
		List<Rating> setratingList = ratings.stream().map(r -> {
			
			User user = userService.getUserSimpleController(r.getUserId());
			r.setUser(user);
			return r;
		}).collect(Collectors.toList());
		
		hotel.setRatings(setratingList);
		
		return hotel;
	}
	
	

}
