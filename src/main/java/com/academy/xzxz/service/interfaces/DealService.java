package com.academy.xzxz.service.interfaces;

import com.academy.xzxz.service.dto.DealDto;

import java.util.List;

public interface DealService {
    void createDeal(String customerName, String customerSurname, double amount, String carName,
                    double bodyPrice, String equipmentName, String engineName, double enginePrice,
                    int enginePower, String batteryCapacity, double batteryPrice, String wheelRadius,
                    double wheelPrice);

    List<DealDto> findAll();
}
