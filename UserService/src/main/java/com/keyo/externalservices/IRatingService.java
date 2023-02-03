package com.keyo.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.keyo.entities.Rating;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface IRatingService {

	@PostMapping("/ratings/")
	public Rating createRating(Rating values);
	
	
//	@PutMapping("/ratings/{ratingId}")
//	public Rating updateRating(@PathVariable String ratingId,@RequestBody Rating values);

	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);
}
