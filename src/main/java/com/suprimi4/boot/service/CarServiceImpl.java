package com.suprimi4.boot.service;

import com.suprimi4.boot.model.Car;
import com.suprimi4.boot.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;


    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }



    @Override
    public List<Car> getListOfCarsByCount(int count) {
        return carRepository.getCarsByLimit(count);

    }
}
