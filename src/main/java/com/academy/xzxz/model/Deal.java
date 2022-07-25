package com.academy.xzxz.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "deal")
@Builder
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_surname")
    private String customerSurname;

    @Column(name = "amount")
    private double amount;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "body_price")
    private double bodyPrice;

    @Column(name = "equipment_name")
    private String equipmentName;

    @Column(name = "engine_name")
    private String engineName;

    @Column(name = "engine_price")
    private double enginePrice;

    @Column(name = "engine_power")
    private int enginePower;

    @Column(name = "battery_capacity")
    private String batteryCapacity;

    @Column(name = "battery_price")
    private double batteryPrice;

    @Column(name = "wheel_radius")
    private String wheelRadius;

    @Column(name = "wheel_price")
    private double wheelPrice;

}
