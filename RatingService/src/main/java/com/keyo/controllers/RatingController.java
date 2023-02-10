package com.keyo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keyo.entities.Rating;
import com.keyo.services.IRatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private IRatingService ratingService;
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping("/")
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		
		return new ResponseEntity<Rating>(ratingService.createRating(rating),HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Rating>> getAllRAtings(){
		
		return new ResponseEntity<List<Rating>>(ratingService.getRatings(),HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		
		return new ResponseEntity<List<Rating>>(ratingService.getRatingByHotelId(hotelId),HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		
		return new ResponseEntity<List<Rating>>(ratingService.getRatingByUserId(userId),HttpStatus.OK);
	}
	
	@PutMapping("/updateRating")
	public ResponseEntity<Rating> updateRating(@RequestBody Rating rating){
		
		return new ResponseEntity<Rating>(ratingService.updateRating(rating),HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteRating(@PathVariable String ratingId){
		
		return new ResponseEntity<String>(ratingService.deleteRating(ratingId),HttpStatus.OK);
	}
 
}
