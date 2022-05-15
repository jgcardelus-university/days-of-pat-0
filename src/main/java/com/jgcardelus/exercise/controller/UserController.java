package com.jgcardelus.exercise.controller;

import com.jgcardelus.exercise.join.UserDocumentJoin;
import com.jgcardelus.exercise.models.UserModels;
import com.jgcardelus.exercise.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity<Iterable<UserModels>> retrieveAll() {
        return ResponseEntity.ok().body(service.retrieveAll());
    }

    @GetMapping("/users/join")
    public ResponseEntity<Iterable<UserDocumentJoin>> retrieveUserDocumentJoin() {
        return ResponseEntity.ok().body(service.retrieveUserDocumentJoin());
    }

    // @PostMapping("/users")
    // public ResponseEntity<UserModel> create(@RequestBody UserModel newUser) {
    //     UserModel user = service.create(newUser);
    // }

    // @PutMapping("/users/{id}")
    // public ResponseEntity<UserModel> create(@PathVariable Long id, @RequestBody UserModel newUser) {
    //     UserModel user = service.update(newUser);
    // }
}
