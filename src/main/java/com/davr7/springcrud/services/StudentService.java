package com.davr7.springcrud.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davr7.springcrud.dtos.StudentDTO;
import com.davr7.springcrud.dtos.StudentResDTO;
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

	public List<StudentResDTO> readAllStudents() {
		List<Student> list = repository.findAll();
		return list.stream()
				.map(s -> StudentResDTO.create(s))
				.collect(Collectors.toList());
	}

	public StudentResDTO readStudentById(Long id) {
		Optional<Student> student = repository.findById(id);
		return StudentResDTO.create(student.orElseThrow(() -> new ResourceNotFoundException(id)));
	}

	public Boolean studentAlreadyExists(String email) {
		return repository.existsByEmail(email);
	}

	public StudentResDTO createStudent(StudentDTO obj) {
		try {
			if (studentAlreadyExists(obj.email())) {
				throw new EntityExistsException();
			}
			
			Student savedUser = repository.save(new Student(obj));
			return StudentResDTO.create(savedUser);
		} catch(EntityExistsException e) {
			throw new ExistingResourceException(obj.email());
		}
	}

	public StudentResDTO updateStudent(Long id, StudentDTO obj) {
		try {
			Student entity = repository.getReferenceById(id);
			
			entity.setFullname(obj.fullname());
			entity.setEmail(obj.email());
			entity.setPhone(obj.phone());
			entity.setPassword(obj.password());
			
			Student savedUser = repository.save(entity);
			return StudentResDTO.create(savedUser);
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
