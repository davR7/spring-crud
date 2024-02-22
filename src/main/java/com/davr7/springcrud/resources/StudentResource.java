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

import com.davr7.springcrud.dtos.StudentDTO;
import com.davr7.springcrud.dtos.StudentResDTO;
import com.davr7.springcrud.services.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "students")
public class StudentResource {
	
	@Autowired
	private StudentService service;
	
	@GetMapping
	public ResponseEntity<List<StudentResDTO>> readAllStudents(){
		List<StudentResDTO> students = service.readAllStudents();
		return ResponseEntity.ok().body(students);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentResDTO> readStudentById(@PathVariable Long id){
		StudentResDTO student = service.readStudentById(id);
		return ResponseEntity.ok().body(student);
	}
	
	@PostMapping
	public ResponseEntity<StudentResDTO> createStudent(@Valid @RequestBody StudentDTO obj){
		StudentResDTO student = service.createStudent(obj);
		
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(student.id())
                .toUri();
		
		return ResponseEntity.created(location).body(student);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<StudentResDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO obj) {
		StudentResDTO student = service.updateStudent(id, obj);
		return ResponseEntity.ok().body(student);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> removeStudent(@PathVariable Long id){
		service.removeStudent(id);
		return ResponseEntity.noContent().build();
	}
}
