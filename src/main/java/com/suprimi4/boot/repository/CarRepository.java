package com.suprimi4.boot.repository;

import com.suprimi4.boot.model.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(value = "SELECT * FROM cars c LIMIT :count", nativeQuery = true)
    List<Car> getCarsByLimit(@Param("count") int count);

    Car findByUserId(Integer userId);
}
