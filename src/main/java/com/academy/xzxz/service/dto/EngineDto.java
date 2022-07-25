package com.academy.xzxz.service.dto;

import com.academy.xzxz.model.Body;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EngineDto implements Serializable {
    private int id;
    private String name;
    private int power;
    private int torque;
    private Body body;
    private String driveUnit;
    private double price;
}
