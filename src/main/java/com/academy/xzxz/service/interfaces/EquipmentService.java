package com.academy.xzxz.service.interfaces;


import com.academy.xzxz.service.dto.EquipmentDto;

import java.util.List;

public interface EquipmentService {

    List<EquipmentDto> findAll();

    EquipmentDto findById(Integer equipmentId);

    void createNewEquipment(String name, int engineId, int batteryId, int bodyId, double accelerate, int maxSpeed);

    void deleteById(Integer equipmentId);

    void updateEquipment(int id, String name, int engineId, int batteryId, int bodyId, double accelerate, int maxSpeed);

    List<EquipmentDto> findAllEnginesForCurrentBody(int bodyId);
}
