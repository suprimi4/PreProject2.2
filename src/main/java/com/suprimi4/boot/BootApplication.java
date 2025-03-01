package com.suprimi4.boot;

import com.suprimi4.boot.model.Car;
import com.suprimi4.boot.model.User;
import com.suprimi4.boot.repository.CarRepository;
import com.suprimi4.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication

public class BootApplication {


    CarRepository carRepository;


    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    public BootApplication(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            Car car = new Car("Tesla", "Model X", 2022, 10000000);
            User user = userRepository.findById(5).get();
            user.setCar(car);
            userRepository.save(user);
//			carRepository.save(new Car("Honda", "Civic", 2020));
//			carRepository.save(new Car("Ford", "Mustang", 2021));
//			carRepository.save(new Car("Toyota", "Corolla", 2019));
//			carRepository.save(new Car("Chevrolet", "Camaro", 2023));
        };
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
