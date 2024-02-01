package com.davr7.springcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davr7.springcrud.entities.Student;
import com.davr7.springcrud.repositories.StudentRepository;
import com.davr7.springcrud.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public List<Student> readAllStudents() {
		return repository.findAll();
	}

	public Student readStudentById(Long id) {
		Optional<Student> student = repository.findById(id);
		return student.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Student createStudent(Student obj) {
		return repository.save(obj);
	}

	public Student updateStudent(Long id, Student obj) {
		try {
			Student entity = repository.getReferenceById(id);
			entity.setFullname(obj.getFullname());
			entity.setEmail(obj.getEmail());
			entity.setPhone(obj.getPhone());
			entity.setPassword(obj.getPassword());
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void removeStudent(Long id) {
		try {
			if (repository.existsById(id)) {
				repository.deleteById(id);
				return;
			}
			throw new EntityNotFoundException();
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
