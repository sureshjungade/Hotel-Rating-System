package com.keyo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.keyo.entities.Rating;
import com.keyo.externalservices.IRatingService;


@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Autowired
//	private IRatingService ratingService;
	
//	@Test
//	void createRating() {
//		Rating rating = Rating.builder().rating("10").userId("").hotel(null).feedback("this is "
//				+ "craeted using feign client").build();
//		Rating savedRating = ratingService.createRating(rating);
//		
//		System.out.println("craeted new rating");
//	}
}
