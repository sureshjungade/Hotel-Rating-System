package com.keyo.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.keyo.entities.User;

@FeignClient(name = "USER-SERVICE")
public interface IUserService {

	
	@GetMapping("/users/getsimplecontroller/{userId}")
	public User getUserSimpleController(@PathVariable String userId);
}
