package com.jgcardelus.exercise.repository;

import com.jgcardelus.exercise.models.UserModels;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModels, Long>{
    
}
