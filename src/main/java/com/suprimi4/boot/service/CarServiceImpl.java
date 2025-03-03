package com.suprimi4.boot.service;

import com.suprimi4.boot.model.Car;
import com.suprimi4.boot.repository.CarRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Value("${maxCars}")
    private Integer maxCars;
    private CarRepository carRepository;


    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public List<Car> getListOfCarsByCount(Integer count) {
        if (count == null || count > maxCars) {
            count = maxCars;
        }
        return carRepository.getCarsByLimit(count);

    }
}
