package com.suprimi4.boot.repository;

import com.suprimi4.boot.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car, Integer> {

    Page<Car> findAll(Pageable pageable);
}
