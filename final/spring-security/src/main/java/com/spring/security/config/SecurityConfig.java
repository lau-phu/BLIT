package com.spring.security.config;

import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.spring.security.service.UserServiceImpl;

@Configuration
@EnableWebSecurity 
public class SecurityConfig {


	@Value("${security.jwt.secret-key}")
	private String jwtSecretKey;

	@Autowired
	UserServiceImpl userService;
	/*
	 * @Autowired JwtTokenFilter jwtAuthenticationFilter;
	 */



	@Bean PasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}

	@Bean public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
	
		http.csrf(AbstractHttpConfigurer::disable)  ////.cors(Customizer.withDefaults())
	    .authorizeHttpRequests(request -> request
	        .requestMatchers("/").permitAll()
	        .requestMatchers("/register").permitAll()
	        .requestMatchers("/login").permitAll()
	        .requestMatchers("/admin").permitAll()
	        .requestMatchers("/client").permitAll()
	        .requestMatchers("/diary").permitAll()
	        .requestMatchers("/writer").permitAll()
	        .anyRequest().authenticated()
	    )
	    .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
	    .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

	return http.build();
	}



	@Bean 
	public AuthenticationManager authenticationManager(UserServiceImpl userService) throws Exception {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return new ProviderManager(authenticationProvider);

	}

	@Bean 
	public JwtDecoder jwtDecoder() {
		var secretKey = new SecretKeySpec(jwtSecretKey.getBytes(), "");
		return NimbusJwtDecoder.withSecretKey(secretKey)
				.macAlgorithm(MacAlgorithm.HS256).build();

	}

	
//	   @Autowired
//	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.userDetailsService(userService);
//	    }
	
	//Global CORS filter
	/*
	 * @Bean CorsConfigurationSource corsConfigurationSource(){
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); CorsConfiguration config = new
	 * CorsConfiguration(); config.setAllowedOrigins(Arrays.asList("*"));
	 * config.setAllowedMethods(Arrays.asList("*"));
	 * config.setAllowedHeaders(Arrays.asList("*"));
	 * config.setAllowCredentials(false); config.applyPermitDefaultValues();
	 * source.registerCorsConfiguration("/**",config); return source; }
	 */

	

}