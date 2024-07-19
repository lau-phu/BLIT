/*
 * package com.spring.security.config;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.stereotype.Service;
 * 
 * import com.spring.security.dto.SignInRequest; import
 * com.spring.security.dto.SignUpRequest; import
 * com.spring.security.entity.User; import
 * com.spring.security.repository.UserRepository;
 * 
 * @Service public class AuthenticationService {
 * 
 * @Autowired UserRepository userRepository;
 * 
 * @Autowired PasswordEncoder passwordEncoder;
 * 
 * @Autowired AuthenticationManager authenticationManager;
 * 
 * 
 * public User signUp(SignUpRequest request) { User user=new User();
 * user.setUsername("Preeti"); user.setEmail(request.getEmail());
 * user.setPassword(passwordEncoder.encode(request.getPassword()));
 * user.setRole("admin");
 * 
 * return userRepository.save(user);
 * 
 * }
 * 
 * 
 * public Object login(SignInRequest request) { // TODO Auto-generated method
 * stub return null; }
 * 
 * }
 */