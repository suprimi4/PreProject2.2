package com.suprimi4.boot.service;

import com.suprimi4.boot.model.Car;
import com.suprimi4.boot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    @Value("${cars.params.sortBy}")
    private String sorts;
    @Value("${cars.params.maxCars}")
    private Integer maxCars;


    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public List<Car> getListOfCarsByCount(Integer count, String typeSort) {

        if (typeSort != null && !sorts.contains(typeSort)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Сортировка недопустима");
        }
        count = (count == null || count > maxCars) ? maxCars : count;
        Pageable page = typeSort == null
                ? PageRequest.of(0, count)
                : PageRequest.of(0, count, Sort.by(typeSort));


        return carRepository.findAll(page).getContent();

    }
}
