package com.hb.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hb.springboot.entity.User;


// JpaRepository<User, Long> 
// here User is type og class & 2nd param is type of Primary Key 
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUserEmail(String userEmail);
}
