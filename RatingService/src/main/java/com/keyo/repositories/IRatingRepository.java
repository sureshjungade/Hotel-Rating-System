package com.keyo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyo.entities.Rating;

@Repository
public interface IRatingRepository extends JpaRepository<Rating, String>{
	
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);

}
