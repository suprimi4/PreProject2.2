package com.suprimi4.boot.controller;

import com.suprimi4.boot.model.Car;
import com.suprimi4.boot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;



    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getCars(@RequestParam(value = "count", required = false) Integer count, @RequestParam(value = "sortBy",required = false) String typeSort, Model model) {

        List<Car> cars = carService.getListOfCarsByCount(count, typeSort);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
