package com.jgcardelus.exercise.controller;

import com.jgcardelus.exercise.join.UserDocumentJoin;
import com.jgcardelus.exercise.models.UserModels;
import com.jgcardelus.exercise.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserE2EControllerTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void usersEndpoinTest() {
        Iterable<UserModels> users = userRepository.findAll();

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/users";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<UserModels>> result = testRestTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<Iterable<UserModels>>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(users);
    }

    @Autowired
    private JdbcTemplate template;

    @Test
    public void usersJoinEndpoinTest() {
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

        String url = "http://localhost:" + Integer.toString(port) + "/api/v1/users/join";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Iterable<UserDocumentJoin>> result = testRestTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            new ParameterizedTypeReference<Iterable<UserDocumentJoin>>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(userDocumentJoins);
    }
}
