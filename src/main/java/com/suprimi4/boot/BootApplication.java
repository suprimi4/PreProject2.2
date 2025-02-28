package com.suprimi4.boot;

import com.suprimi4.boot.model.Car;
import com.suprimi4.boot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

public class BootApplication {
	@Autowired
	CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			carRepository.save(new Car("Tesla", "Model X", 2022));
			carRepository.save(new Car("Honda", "Civic", 2020));
			carRepository.save(new Car("Ford", "Mustang", 2021));
			carRepository.save(new Car("Toyota", "Corolla", 2019));
			carRepository.save(new Car("Chevrolet", "Camaro", 2023));
		};
	}

}
