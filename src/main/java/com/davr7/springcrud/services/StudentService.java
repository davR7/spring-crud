package com.davr7.springcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davr7.springcrud.entities.Student;
import com.davr7.springcrud.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public List<Student> readAllStudents(){
		return repository.findAll();
	}
	
	public Student readStudentById(Long id) {
		Optional<Student> student = repository.findById(id);
		return student.get();
	}
}