package com.davr7.springcrud.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.davr7.springcrud.entities.Student;
import com.davr7.springcrud.repositories.StudentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private StudentRepository stuRepository;

	@Override
	public void run(String... args) throws Exception {
		Student stu1 = new Student(null, "Davi Melo", "davi@test.com", "995518844", "12345");
		Student stu2 = new Student(null, "Raquel Barros", "raquel@test.com", "992518512", "12345");
		Student stu3 = new Student(null, "Ana Mendes", "maria@test.com", "995571002", "12345");
		Student stu4 = new Student(null, "Carlos Dantas", "carlos@test.com", "995561821", "12345");
		
		stuRepository.saveAll(Arrays.asList(stu1, stu2, stu3, stu4));
	}

}
