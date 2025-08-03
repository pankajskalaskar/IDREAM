package com.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Slf4j
@Validated
public class RegisterRequest {
	
	
	@Schema(example = "Pkalas01")
	@NotBlank(message = "Username cannot be empty")
	@JsonProperty (value = "username")
	private String username;
	
	@Schema(example = "pankajskalaskar@gmail.com")
	@NotBlank(message = "Email cannot be empty")
	@Email(message = "Invalid email format")
	@JsonProperty (value = "email")
	private String email;
	
	@Schema(example = "Pankaj")
	@NotBlank(message = "First name cannot be empty")
	@JsonProperty (value = "firstname")
	private String firstname;
	
	@Schema(example = "Suresh")
	@NotBlank(message = "Middle name cannot be empty")
	@JsonProperty (value = "middlename")
	private String middlename;
	
	@Schema(example = "Kalaskar")
	@NotBlank(message = "Last name cannot be empty")
	@JsonProperty (value = "lastname")
	private String lastname;
	
	@NotBlank(message = "Mobile number cannot be empty")
	@Size(min = 8, message = "Mobile number must be at least 10 characters long")
	@Column(length = 10)
	@JsonProperty (value = "mobilenumber")
	private long mobilenumber;
	
	@Schema(example = "Pank123")
	@NotBlank(message = "Password cannot be empty")
	@Size(min = 8, message = "Password must be at least 8 characters long")
	@Column(length = 50)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "Password must contain at least one lowercase letter, one uppercase letter, and one digit") 
	@JsonProperty (value = "password")
	private String password;

	public String getEmail() {
		
		return null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "RegisterRequest [username=" + username + ", email=" + email + ", firstname=" + firstname
				+ ", middlename=" + middlename + ", lastname=" + lastname + ", mobilenumber=" + mobilenumber
				+ ", password=" + password + "]";
	}

	
	
	
	
}


