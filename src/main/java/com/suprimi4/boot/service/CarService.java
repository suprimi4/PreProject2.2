package com.suprimi4.boot.service;

import com.suprimi4.boot.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getListOfCarsByCount(int count);
}
