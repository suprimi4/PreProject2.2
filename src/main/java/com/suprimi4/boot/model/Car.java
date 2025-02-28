package com.suprimi4.boot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mark;
    private String model;
    private int yearOfManufacture;

    public Car() {
    }

    public Car(int id, String mark, String model, int yearOfManufacture) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    public Car(String mark, String model, int yearOfManufacture) {
        this.mark = mark;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
}
