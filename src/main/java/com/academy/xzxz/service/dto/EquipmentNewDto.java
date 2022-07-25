package com.academy.xzxz.service.dto;


import com.academy.xzxz.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentNewDto {

    private int id;
    private String name;
    private String status;
    private double acceleration;
    private int maxSpeed;
    private Engine engine;
    private Body body;
    private Battery battery;

}
