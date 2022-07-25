package com.academy.xzxz.service.mappers;


import com.academy.xzxz.model.Equipment;
import com.academy.xzxz.service.dto.EquipmentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {

    EquipmentDto toEquipmentDto(Equipment equipment);
    Equipment toEquipment(EquipmentDto equipmentDto);

}
