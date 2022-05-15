package com.jgcardelus.exercise.repository;

import com.jgcardelus.exercise.models.DocumentModels;

import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<DocumentModels, Long> {
    
}
