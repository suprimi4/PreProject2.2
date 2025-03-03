package com.suprimi4.boot.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cars")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private final String mark;
    private final String model;
    private final int yearOfManufacture;
    private final int cost;
    @OneToOne(mappedBy = "car")
    private User user;


}
