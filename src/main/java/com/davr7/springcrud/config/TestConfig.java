package com.davr7.springcrud.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.davr7.springcrud.entities.Article;
import com.davr7.springcrud.entities.Student;
import com.davr7.springcrud.repositories.ArticleRepository;
import com.davr7.springcrud.repositories.StudentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private StudentRepository stuRepository;
	
	@Autowired
	private ArticleRepository artRepository;

	@Override
	public void run(String... args) throws Exception {
		Student stu1 = new Student(null, "Davi Melo", "davi@test.com", "995518844", "12345");
		Student stu2 = new Student(null, "Raquel Barros", "raquel@test.com", "992518512", "12345");
		Student stu3 = new Student(null, "Ana Mendes", "maria@test.com", "995571002", "12345");
		Student stu4 = new Student(null, "Carlos Dantas", "carlos@test.com", "995561821", "12345");
		
		Article art1 = new Article(null, "Conhecendo o Spring Boot.", "Spring Boot é uma ferramenta que facilita e agiliza o desenvolvimento de aplicativos da web e de microsserviços.", "....");
		Article art2 = new Article(null, "Os Pilares do POO.", "Para entender POO, é fundamental compreender os quatro pilares que sustentam esse paradigma.", "....");
		Article art3 = new Article(null, "O PHP morreu?", "PHP morreu? Suas melhorias contínuas, foco na criação de aplicações web dinâmicas e importância inegável no mundo da programação.", "....");
		Article art4 = new Article(null, "O que é NodeJS?", "Node.js é um software de código aberto, multiplataforma, baseado no interpretador V8 do Google.", "....");
		Article art5 = new Article(null, "Principais comandos do Git", "Explore os comandos fundamentais do Git que serão essenciais no início da sua jornada como DEV.", "....");
		
		stuRepository.saveAll(Arrays.asList(stu1, stu2, stu3, stu4));
		artRepository.saveAll(Arrays.asList(art1, art2, art3, art4, art5));
	}

}
