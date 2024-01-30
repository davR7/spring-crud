package com.davr7.springcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davr7.springcrud.entities.Article;
import com.davr7.springcrud.repositories.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository repository;
	
	public List<Article> readAllArticles() {
		return repository.findAll();
	}

	public Article readArticleById(Long id) {
		Optional<Article> article = repository.findById(id);
		return article.get();
	}
}
