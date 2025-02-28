package com.suprimi4.boot.controller;

import com.suprimi4.boot.model.Car;
import com.suprimi4.boot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    @Value("${maxCars}")
    private Integer maxCars;
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count == null || count > maxCars) {
            count = maxCars;
        }

        List<Car> cars = carService.getListOfCarsByCount(count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
