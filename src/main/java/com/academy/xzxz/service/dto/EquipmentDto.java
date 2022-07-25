package com.academy.xzxz.service.dto;

import com.academy.xzxz.model.Battery;
import com.academy.xzxz.model.Body;
import com.academy.xzxz.model.Engine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentDto implements Serializable {
    private int id;
    private String name;
    private Engine engine;
    private Battery battery;
    private Body body;
    private double accelerate;
    private int maxSpeed;
}
