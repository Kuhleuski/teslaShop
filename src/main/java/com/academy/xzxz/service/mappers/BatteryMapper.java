package com.academy.xzxz.service.mappers;

import com.academy.xzxz.model.Battery;
import com.academy.xzxz.service.dto.BatteryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BatteryMapper {

    BatteryDto toBatteryDto(Battery battery);
    Battery toBattery(BatteryDto batteryDto);

}
