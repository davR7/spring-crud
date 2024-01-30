package com.davr7.springcrud.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davr7.springcrud.entities.Student;
import com.davr7.springcrud.services.StudentService;

@RestController
@RequestMapping(value = "students")
public class StudentResource {
	
	@Autowired
	private StudentService service;
	
	@GetMapping
	public ResponseEntity<List<Student>> readAllStudents(){
		List<Student> students = service.readAllStudents();
		return ResponseEntity.ok().body(students);
	}
}
