package com.suprimi4.boot.model;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    private Integer id;
    @Column(name = "income")
    private Integer income;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;


    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public boolean isEmpty() {
        return id == null;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
