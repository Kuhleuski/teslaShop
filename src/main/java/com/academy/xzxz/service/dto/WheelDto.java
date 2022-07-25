package com.academy.xzxz.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WheelDto implements Serializable {

    private int id;
    //    @NotEmpty(message = "Type should not be empty")
    //    @Size(min = 2, max = 30, message = "Type should be between 2 and 30 characters")
    private String radius;
    //        @Min(value = 2, message = "Age must be between 2 and 30")
    //    @Max(value = 30, message = "Age must be between 2 and 30")
    private String type;

    //    @Min(value = 1, message = "Price should be greater than 0")
    private double price;

}
