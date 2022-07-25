package com.academy.xzxz.service.mappers;

import com.academy.xzxz.model.Car;
import com.academy.xzxz.service.dto.CarDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDto toCarDto(Car car);
    Car toCar(CarDto carDto);
}
