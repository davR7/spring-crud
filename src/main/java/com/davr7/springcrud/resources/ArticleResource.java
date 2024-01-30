package com.davr7.springcrud.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davr7.springcrud.entities.Article;
import com.davr7.springcrud.services.ArticleService;

@RestController
@RequestMapping(value = "articles")
public class ArticleResource {
	
	@Autowired
	private ArticleService service;
	
	@GetMapping
	public ResponseEntity<List<Article>> readAllArticles(){
		List<Article> articles = service.readAllArticles();
		return ResponseEntity.ok().body(articles);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Article> readArticleById(@PathVariable Long id){
		Article article = service.readArticleById(id);
		return ResponseEntity.ok().body(article);
	}
}
