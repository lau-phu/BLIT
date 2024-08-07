package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.customAnnotation.RandomField;
import com.example.demo.model.Writer;


/*
	Spring boot application functions-
	enable configuration
	auto configuration
	component scan	
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		System.out.println("ayyy lmao");
		
		
	}

	
	/*
	3 part of JWT - java web token
	
	header - algorithm used for validation
	
	payload - user information provided
	
	signature - cryptographic signature, or secret key
	
	JPA is an interface part of java EE that deals with ORM
	define methods such as CRUD
	and for paging+proding repository (operation in batch)
	have persistence such as session

	spring data JPA is the implementation of JPA

	hibernate is an implementation tool that deals with ORM
	take the entity class and map it to the database
	
	dependency injection
	
	XML configuration -injecting uses setter or constructor
	
	annotation
	
	field injection by creating a bean
	
	taken care off by the IOC - container responsible for injection
	
	bean factory - most basic of the IOC container that helps with injection
	
	application context - extends bean factory to provide more befits
	
	
	bean lifecycle
	
	instantiate by the IOC (inversion of control) container 
	- can be initialized by init function, @PostContruct
	getting injected
	execution
	pre-destroy - memory clean up, check for usage, make sure it safe to destroy
	@PreDestroy
	getting destroy - can be initialized by the destroy function
	
	@Qualifier
	decide which bean of the same name or the same type to be injected
	

	transient  variable - will not be serialized. can be used @json ignore
	*/
	

	
	
}
