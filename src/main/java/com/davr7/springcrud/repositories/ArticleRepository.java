package com.davr7.springcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.davr7.springcrud.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}
