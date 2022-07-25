package com.academy.xzxz.model;


import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "body")
@Builder
public class Body {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @Column(name = "weight")
    private double weight;

    @Column(name = "width")
    private double width;

    @Column(name = "height")
    private double height;

    @Column(name = "length")
    private double length;

    @Column(name = "trunk")
    private int trunk;

    @Column(name = "wheel_base")
    private double wheelBase;

    @Column(name = "price")
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return id == body.id && numberOfSeats == body.numberOfSeats && Double.compare(body.weight, weight) == 0 && Double.compare(body.width, width) == 0 && Double.compare(body.height, height) == 0 && Double.compare(body.length, length) == 0 && trunk == body.trunk && Double.compare(body.wheelBase, wheelBase) == 0 && Double.compare(body.price, price) == 0 && Objects.equals(name, body.name) && Objects.equals(type, body.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, numberOfSeats, weight, width, height, length, trunk, wheelBase, price);
    }
}
