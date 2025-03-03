package com.suprimi4.boot.datareciever;

import com.suprimi4.boot.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class UserFetcher {

    private final RestTemplate restTemplate;

    @Value("${sources.url}")
    private String url;

    public UserFetcher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> fetch() {
        ResponseEntity<List<User>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        return response.getBody();
    }
}
