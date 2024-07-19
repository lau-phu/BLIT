package com.spring.security.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class SignUpRequest {

   @NotEmpty
   private String firstName;
   
 
	private String lastName;
	
//   @NotEmpty
	//@Column(unique=true)
	private String userName;
   
   @NotEmpty
   @Size(min = 6, message = "Minimum password length ")
	private String password;
	
	@NotEmpty
	@Column(unique=true, updatable=false, nullable=false)
	private String email;
	
	
	private String phone;
	
	private String address;
	
	private String role;

	public SignUpRequest(@NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String userName,
			@NotEmpty @Size(min = 6, message = "Minimum password length ") String password, @NotEmpty String email,
			String phone, String address, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role=role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
		

}
