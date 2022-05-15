package com.jgcardelus.exercise.service.impl;

import com.jgcardelus.exercise.models.DocumentModels;
import com.jgcardelus.exercise.repository.DocumentRepository;
import com.jgcardelus.exercise.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentRepository repository;

    @Override
    public Iterable<DocumentModels> retrieveAll() {
        return repository.findAll();
    }
}
