package com.suprimi4.boot;

import com.suprimi4.boot.datareciever.UserFetcher;
import com.suprimi4.boot.repository.CarRepository;
import com.suprimi4.boot.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication

public class BootApplication {
    private UserFetcher userFetcher;

    private CarRepository carRepository;


    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    public BootApplication(@Lazy UserFetcher userFetcher, CarRepository carRepository, UserRepository userRepository) {
        this.userFetcher = userFetcher;
        this.carRepository = carRepository;
        this.userRepository = userRepository;

    }




    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
