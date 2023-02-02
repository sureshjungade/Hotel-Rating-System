package com.keyo.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keyo.entities.Rating;
import com.keyo.repositories.IRatingRepository;
import com.keyo.services.IRatingService;

@Service
public class RatingServiceImpl implements IRatingService{
	
	@Autowired
	private IRatingRepository ratingRepo;

	@Override
	public Rating createRating(Rating rating) {
		
		String ratingId = UUID.randomUUID().toString();
		
		rating.setRatingId(ratingId);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatings() {

		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

}
