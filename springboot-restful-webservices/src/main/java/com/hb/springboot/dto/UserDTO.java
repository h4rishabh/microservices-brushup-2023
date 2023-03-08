package com.hb.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private Long id;
	
	// user first name should not be null or empty
	@NotEmpty(message = "User's firstName should not be null or empty")
	private String firstName;
	
	// user lastName should not be null or empty
	@NotEmpty(message="User's lastName should not be null or empty")
	private String lastName;
	
	// user email should not be null or empty
	// email should be valid 
	@NotEmpty(message = "User's email should not be null or empty")
	@Email(message = "email should be valid")
	private String userEmail;
}
