package com.academy.xzxz.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "battery")
@Builder
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "capacity")
    private String capacity;

    @Column(name = "reserve")
    private int reserve;

    @Column(name = "status")
    private boolean status;

    @Column(name = "price")
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Battery battery = (Battery) o;
        return id == battery.id && reserve == battery.reserve && Double.compare(battery.price, price) == 0 && Objects.equals(capacity, battery.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, capacity, reserve, price);
    }
}
