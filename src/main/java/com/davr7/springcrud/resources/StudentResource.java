package com.davr7.springcrud.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Student> readStudentById(@PathVariable Long id){
		Student student = service.readStudentById(id);
		return ResponseEntity.ok().body(student);
	}
	
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student obj){
		Student student = service.createStudent(obj);
		
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(student.getId())
                .toUri();
		
		return ResponseEntity.created(location).body(student);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student obj) {
		Student student = service.updateStudent(id, obj);
		return ResponseEntity.ok().body(student);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> removeStudent(@PathVariable Long id){
		service.removeStudent(id);
		return ResponseEntity.noContent().build();
	}
}
