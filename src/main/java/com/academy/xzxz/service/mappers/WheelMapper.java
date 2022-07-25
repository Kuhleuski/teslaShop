package com.academy.xzxz.service.mappers;

import com.academy.xzxz.model.Wheel;
import com.academy.xzxz.service.dto.WheelDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface WheelMapper {

    WheelDto toWheelDto(Wheel wheel);

    Wheel toWheel(WheelDto wheelDto);
}
