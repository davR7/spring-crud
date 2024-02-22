package com.davr7.springcrud.dtos;

import java.time.Instant;

import com.davr7.springcrud.entities.Student;

public record StudentResDTO(Long id, String fullname, String email, String phone, Instant createdAt, Instant updatedAt) {
	
	public static StudentResDTO create(Student st) {
		return new StudentResDTO(st.getId(), st.getFullname(), st.getEmail(), st.getPhone(), st.getCreatedAt(), st.getUpdatedAt());
	}
}
