package com.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.dto.SignUpRequest;
import com.spring.security.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer>{
	
	public AppUser findByEmail(String email);
	public AppUser findByUserName(String userName);
	
	public SignUpRequest save(SignUpRequest request);
	
}
