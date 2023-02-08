package com.keyo.services;

import java.util.List;

import com.keyo.entities.Hotel;

public interface IHotelServices {
	
	Hotel create(Hotel hotel);
	
	
	List<Hotel> getAll();
	
	Hotel get(String hotelId);
	
	Hotel getCombinedData(String hotelId);

}
