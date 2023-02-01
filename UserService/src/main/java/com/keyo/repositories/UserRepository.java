package com.keyo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keyo.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}
