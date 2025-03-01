package com.suprimi4.boot.dataReciever;

import com.suprimi4.boot.model.User;
import com.suprimi4.boot.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserReciever {
    private final RestTemplate restTemplate;
    private final UserRepository userRepository;
    @Value("${sources.url}")
    private String url;


    public UserReciever(RestTemplate restTemplate, UserRepository userRepository) {
        this.restTemplate = restTemplate;
        this.userRepository = userRepository;
    }

    @PostConstruct
    @Transactional
    public void fetchUsers() {
        ResponseEntity<List<User>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        List<User> jsonObjects = response.getBody();
        userRepository.saveAll(jsonObjects);
    }
}
