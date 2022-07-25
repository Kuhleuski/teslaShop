package com.academy.xzxz.service.interfaces;

import com.academy.xzxz.service.dto.EngineDto;
import com.academy.xzxz.service.dto.WheelDto;

import java.util.List;

public interface EngineService {

    List<EngineDto> findAll();

    EngineDto findById(Integer engineId);

    void createNewEngine(String name, int power, int torque, String driveUnit,
                         int bodyId, double price);

    void deleteById(Integer engineId);

    void updateEngine(EngineDto engineDto);

    List<EngineDto> findEnginesForBody(int bodyId);

}
