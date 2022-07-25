package com.academy.xzxz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "equipment")
@Builder
public class Equipment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;


    @ManyToOne
    @JoinColumn(name = "battery_id")
    private Battery battery;

    @ManyToOne
    @JoinColumn(name = "body_id")
    private Body body;

    @Column(name = "accelerate")
    private double accelerate;

    @Column(name = "max_speed")
    private int maxSpeed;

}
