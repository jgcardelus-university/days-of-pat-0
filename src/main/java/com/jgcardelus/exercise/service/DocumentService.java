package com.jgcardelus.exercise.service;

import com.jgcardelus.exercise.models.DocumentModels;

public interface DocumentService {
    Iterable<DocumentModels> retrieveAll();
}
