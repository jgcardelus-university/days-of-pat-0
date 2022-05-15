package com.jgcardelus.exercise.service;

import com.jgcardelus.exercise.join.UserDocumentJoin;
import com.jgcardelus.exercise.models.UserModels;

public interface UserService {
    Iterable<UserModels> retrieveAll();
    Iterable<UserDocumentJoin> retrieveUserDocumentJoin();
}
