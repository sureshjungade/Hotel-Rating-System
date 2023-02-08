package com.keyo.services;

import java.util.List;

import com.keyo.entities.User;

public interface UserService {
	
	User saveUser(User user);
	
	
	List<User> getAllUser();
	
	
	User getUser(String userId);
	
	
	String deleteUser(String userId);
	
	
	User getUserSimplemethod(String userId);
	


}
