package com.keyo.services;

import java.util.List;

import com.keyo.entities.Rating;

public interface IRatingService {
	
	Rating createRating(Rating rating);
	
	List<Rating> getRatings();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);

	Rating updateRating(Rating rating);

	String deleteRating(String ratingId);
}
