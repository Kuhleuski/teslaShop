package com.academy.xzxz.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DealDto {

    private int id;
    private Date date;
    private String customerName;
    private String customerSurname;
    private double amount;
    private String carName;
    private double bodyPrice;
    private String equipmentName;
    private String engineName;
    private double enginePrice;
    private int enginePower;
    private String batteryCapacity;
    private double batteryPrice;
    private String wheelRadius;
    private double wheelPrice;

}
