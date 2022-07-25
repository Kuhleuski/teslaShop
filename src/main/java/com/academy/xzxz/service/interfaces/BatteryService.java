package com.academy.xzxz.service.interfaces;

import com.academy.xzxz.service.dto.BatteryDto;

import java.util.List;

public interface BatteryService {

    List<BatteryDto> findAll();

    BatteryDto findById(Integer batteryId);

    void createNewBattery(String capacity, int reserve, boolean status, double price);

    void deleteById(Integer batteryId);

    void updateBattery(BatteryDto batteryDto);
}
