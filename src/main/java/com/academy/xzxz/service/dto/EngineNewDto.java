package com.academy.xzxz.service.dto;

import com.academy.xzxz.model.Body;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EngineNewDto {

    private int id;
    private String name;
    private String vendorCode;
    private int power;
    private Body body;
    private String driveUnit;
    private double price;
}
