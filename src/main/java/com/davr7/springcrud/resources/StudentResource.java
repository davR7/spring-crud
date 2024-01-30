package com.davr7.springcrud.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davr7.springcrud.services.StudentService;

@RestController
@RequestMapping(value = "students")
public class StudentResource {
	
	@Autowired
	private StudentService service;

}
