package com.spring.security.controller;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.jose.jwk.source.ImmutableSecret;
import com.spring.security.dto.SignInRequest;
import com.spring.security.dto.SignUpRequest;
import com.spring.security.entity.AppUser;
import com.spring.security.repository.UserRepository;
import com.spring.security.service.UserServiceImpl;
import com.spring.security.util.Utility;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

	@Value("${security.jwt.secret-key}")
	private String jwtSecretKey;

	@Value("${security.jwt.issuer}")
	private String jwtIssuer;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private Utility util;


	@GetMapping("/")
	public String welcome() {
		return "Welcome Page";

	}

	@GetMapping("/admin")
	public String admin() {
		return "Admin Page";
	}

	@GetMapping("/client")
	public String client() {
		return "Client Page ";
	}

	
	@PostMapping("/register")
	public ResponseEntity<Object> register(@Valid @RequestBody SignUpRequest signUp, BindingResult result) {

		try {
			if(result.hasErrors()) {
				var errorList=result.getAllErrors();
				var errorMap = new HashMap<String, String>();

				for(int i =0; i<errorList.size(); i++) {
					var error = (FieldError)errorList.get(0);
					errorMap.put(error.getField(), error.getDefaultMessage());
				}
				return ResponseEntity.badRequest().body(errorMap);
			}

			BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
			AppUser user=new AppUser();

			user.setFirstName(signUp.getFirstName());
			user.setLastName(signUp.getLastName());
			user.setUserName(signUp.getUserName());
			user.setEmail(signUp.getEmail());
			//user.setRole(signUp.getRole());
			user.setRole("user");
			user.setCreatedAt(new Date());
			user.setPassword(bcryptEncoder.encode(signUp.getPassword()));


			AppUser otherUser=userRepository.findByUserName(user.getUserName());

			if(otherUser !=null) {
				return ResponseEntity.badRequest().body("This user already exists");
			}

			otherUser=userRepository.findByEmail(user.getEmail());

			if(otherUser !=null) {
				return ResponseEntity.badRequest().body("Email already used.");
			}

			userRepository.save(user);

			String jwtToken= createToken(user);

			var response = new HashMap<String, Object>();
			response.put("token", jwtToken);
			response.put("user", user);

			return ResponseEntity.ok(response);

		}catch(Exception e) {
			System.out.println("Exception occurred !!");
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().body("Error occured");

	}


	@PostMapping("/login")
	public ResponseEntity<Object> login(@Valid @RequestBody SignInRequest signIn, BindingResult result) {


		if(result.hasErrors()) {
			var errorList=result.getAllErrors();
			var errorMap = new HashMap<String, String>();

			for(int i =0; i<errorList.size(); i++) {
				var error = (FieldError)errorList.get(0);
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(errorMap);
		}
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(signIn.getUserName(), signIn.getPassword()));

			AppUser user=userRepository.findByUserName(signIn.getUserName());

			String jwtToken= createToken(user);

			var response = new HashMap<String, Object>();
			response.put("token", jwtToken);
			response.put("user", user);

			return ResponseEntity.ok(response);	

		}catch(Exception e) {
			System.out.println("Exception occurred !!");
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().body("Bad Username or password");

	}
	
	

	@GetMapping("/profile")
	public ResponseEntity<Object> profile(Authentication auth) {
		
		var response = new HashMap<String, Object>();
		response.put("UserName", auth.getName());
		response.put("Authorities", auth.getAuthorities());
		
		
		AppUser user = userRepository.findByUserName(auth.getName());
		response.put("User", user);
		
		return ResponseEntity.ok(response);

	}
	

	

	public String createToken(AppUser appUser) {
		Instant now = Instant.now();

		JwtClaimsSet claims=  JwtClaimsSet.builder().issuer(jwtIssuer)
				.issuedAt(now).expiresAt(now.plusSeconds(24*3600))
				.subject(appUser.getUserName())
				.claim("role", appUser.getRole()).build();


		NimbusJwtEncoder encoder = new NimbusJwtEncoder(new ImmutableSecret<>(jwtSecretKey.getBytes()));

		JwtEncoderParameters params = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);

		return encoder.encode(params).getTokenValue();
	}

	
}