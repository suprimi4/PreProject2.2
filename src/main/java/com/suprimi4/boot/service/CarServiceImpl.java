package com.suprimi4.boot.service;

import com.suprimi4.boot.model.Car;
import com.suprimi4.boot.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;


    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }



    @Override
    public List<Car> getListOfCarsByCount(int count) {
        return carRepository.getCarsByLimit(count);

    }
}
