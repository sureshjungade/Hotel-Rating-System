package com.keyo.externalservices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.keyo.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface IRatingService {
	
	@GetMapping("/ratings/hotels/{hotelId}")
	List<Rating> getRatingByHotelId(@PathVariable String hotelId);

}
