package com.academy.xzxz.service.dto;

import com.academy.xzxz.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDto implements Serializable {

    private int id;
    private Body body;
    private Equipment equipment;
    private Wheel wheel;
    private Color color;
    private CarStatus status;
    private Boolean toning;
}
