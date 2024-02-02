package com.davr7.springcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davr7.springcrud.dtos.StudentRequestDTO;
import com.davr7.springcrud.entities.Student;
import com.davr7.springcrud.repositories.StudentRepository;
import com.davr7.springcrud.services.exceptions.ExistingResourceException;
import com.davr7.springcrud.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityExistsException;
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

	public Boolean studentAlreadyExists(String email) {
		return repository.existsByEmail(email);
	}

	public Student createStudent(StudentRequestDTO obj) {
		try {
			if (studentAlreadyExists(obj.email())) {
				throw new EntityExistsException();
			}
			return repository.save(new Student(obj));
		} catch(EntityExistsException e) {
			throw new ExistingResourceException(obj.email());
		}
	}

	public Student updateStudent(Long id, StudentRequestDTO obj) {
		try {
			Student entity = repository.getReferenceById(id);
			entity.setFullname(obj.fullname());
			entity.setEmail(obj.email());
			entity.setPhone(obj.phone());
			entity.setPassword(obj.password());
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
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
