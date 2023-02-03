package com.keyo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
	
	private String ratingId;
	
	private String userId;
	
	private String hotelId;
	
	private String rating;
	
	private String feedback;
	
	private Hotel hotel;
	
//	public Rating() {
//		super();
//		
//	}
//
//	public Rating(String ratingId, String userId, String hotelId, String rating, String feedback) {
//		super();
//		this.ratingId = ratingId;
//		this.userId = userId;
//		this.hotelId = hotelId;
//		this.rating = rating;
//		this.feedback = feedback;
//	}
//
//	public String getRatingId() {
//		return ratingId;
//	}
//
//	public void setRatingId(String ratingId) {
//		this.ratingId = ratingId;
//	}
//
//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//
//	public String getHotelId() {
//		return hotelId;
//	}
//
//	public void setHotelId(String hotelId) {
//		this.hotelId = hotelId;
//	}
//
//	public String getRating() {
//		return rating;
//	}
//
//	public void setRating(String rating) {
//		this.rating = rating;
//	}
//
//	public String getFeedback() {
//		return feedback;
//	}
//
//	public void setFeedback(String feedback) {
//		this.feedback = feedback;
//	}
	
	

}
