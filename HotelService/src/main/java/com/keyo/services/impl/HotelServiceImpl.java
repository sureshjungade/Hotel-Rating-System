package com.keyo.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keyo.entities.Hotel;
import com.keyo.exception.ResourceNotFoundException;
import com.keyo.repositories.IHotelRespository;
import com.keyo.services.IHotelServices;

@Service
public class HotelServiceImpl implements IHotelServices{

	@Autowired
	private IHotelRespository hotelRepo;
	
	
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
	public Hotel get(String id) {
		return hotelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found!!"));
	}
	
	

}
