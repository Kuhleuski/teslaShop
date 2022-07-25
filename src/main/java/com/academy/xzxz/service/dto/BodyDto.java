package com.academy.xzxz.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BodyDto implements Serializable {
    private int id;
    private String name;
    private String type;
    private int numberOfSeats;
    private double weight;
    private double width;
    private double height;
    private double length;
    private int trunk;
    private double wheelBase;
    private double price;
}
