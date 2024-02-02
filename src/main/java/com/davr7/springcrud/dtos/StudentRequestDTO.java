package com.davr7.springcrud.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record StudentRequestDTO(
		@NotBlank(message = "Fullname is mandatory") 
		String fullname, 
		@NotBlank(message = "Email is mandatory")
		@Email(message = "Invalid email format")
		String email, 
		@NotBlank(message = "Phone is mandatory")
		String phone, 
		@NotBlank(message = "Password is mandatory")
		@Size(min = 6, message = "Password must be at least 6 characters long") 
		String password
		) {
}
