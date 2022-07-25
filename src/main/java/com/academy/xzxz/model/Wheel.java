package com.academy.xzxz.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "wheel")

public class Wheel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "radius")
    private String radius;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private double price;

}
