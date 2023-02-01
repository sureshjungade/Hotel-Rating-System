package com.keyo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keyo.entities.Hotel;
import com.keyo.services.IHotelServices;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private IHotelServices hotelService;
	
		@PostMapping("/createHotel")
		public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
			
			return new ResponseEntity<Hotel>(hotelService.create(hotel), HttpStatus.CREATED);
		}
		
		@GetMapping("/getHotel/{hotelId}")
		public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
			
			return new ResponseEntity<Hotel>(hotelService.get(hotelId), HttpStatus.OK);
		}
		
		@GetMapping("/getAllHotels")
		public ResponseEntity<List<Hotel>> getAllHotel(){
			
			return new ResponseEntity<List<Hotel>>(hotelService.getAll(), HttpStatus.OK);
		}
}
