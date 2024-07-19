package com.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.entity.AppUser;

import com.spring.security.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;


@Service
public class UserServiceImpl implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user= userRepository.findByUserName(username) ;
		
		if(user != null) {
			UserDetails myUser=User.withUsername(username).password(user.getPassword()).roles(user.getRole()).build();
			return myUser;
		}
		return null;
	}
	
}
