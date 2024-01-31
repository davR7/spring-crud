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
	
	public Student createStudent(Student obj) {
		return repository.save(obj);
	}
	
	public Student updateStudent(Long id, Student obj) {
		Student entity = repository.getReferenceById(id);
		entity.setFullname(obj.getFullname());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		entity.setPassword(obj.getPassword());
		return repository.save(entity);
	}
	
	public void removeStudent(Long id) {
		repository.deleteById(id);
	}
}
