package com.davr7.springcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davr7.springcrud.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	boolean existsByEmail(String email);
}
