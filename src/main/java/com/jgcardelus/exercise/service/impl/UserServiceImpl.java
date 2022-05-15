package com.jgcardelus.exercise.service.impl;

import java.util.Optional;

import com.jgcardelus.exercise.join.UserDocumentJoin;
import com.jgcardelus.exercise.models.UserModels;
import com.jgcardelus.exercise.repository.UserRepository;
import com.jgcardelus.exercise.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<UserModels> retrieveAll() {
        return userRepository.findAll();
    }

    @Autowired
    private JdbcTemplate template;

    @Override
    public Iterable<UserDocumentJoin> retrieveUserDocumentJoin() {
        String query = "SELECT * FROM USERS INNER JOIN DOCUMENTS ON USERS.USER_ID = DOCUMENTS.USER_ID";

        Iterable<UserDocumentJoin> userDocumentJoins = template.query(
            query,
            (data, rowNum) -> {
                return new UserDocumentJoin(
                    data.getLong("USERS.USER_ID"),
                    data.getString("USERS.USER"),
                    data.getString("USERS.COMMENT"),
                    data.getLong("DOCUMENTS.DOC_ID"),
                    data.getString("DOCUMENTS.DOC")
                );
            }
        );

        return userDocumentJoins;
    }

    public UserModels create(UserModels user) {
        Optional<UserModels> otherUser = userRepository.findById(user.getUserId());
        if (otherUser.isPresent()) {
            // Cambiar clave primaria
        }

        return userRepository.save(otherUser.get());
    }
}
