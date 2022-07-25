package com.academy.xzxz.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "engine")
@Builder
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;


    @Column(name = "power")
    private int power;

    @Column(name = "torque")
    private int torque;

    @Column(name = "drive_unit")
    private String driveUnit;

    @ManyToOne
    @JoinColumn(name = "body_id")
    private Body body;

    @Column(name = "price")
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return id == engine.id && power == engine.power && torque == engine.torque && Double.compare(engine.price, price) == 0 && Objects.equals(name, engine.name) && Objects.equals(driveUnit, engine.driveUnit) && Objects.equals(body, engine.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, power, torque, driveUnit, body, price);
    }
}
